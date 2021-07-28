package com.basecreator.domain.service;

import com.basecreator.domain.model.team.MailPattern;
import com.basecreator.domain.model.team.MailPatternRepository;
import com.basecreator.utils.CheckMailUtils;
import com.basecreator.web.payload.response.OneMailResponse;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class MailService {
    @Autowired
    private MailPatternRepository mailPatternRepository;

    public MailPattern save(MailPattern mailPattern) {
        return mailPatternRepository.save(mailPattern);
    }

    public List<MailPattern> getAllMailPattern() {
        return mailPatternRepository.findAll();
    }

    public List<String> getEncodedMailAddress(String name, String surname, String domain){
        List<MailPattern> mailPatterns = mailPatternRepository.findAll();

        mailPatterns.parallelStream().forEach(pattern -> {
            pattern.setPattern(pattern.getPattern().replace("{name}", name));
            pattern.setPattern(pattern.getPattern().replace("{surname}", surname));
            pattern.setPattern(pattern.getPattern().replace("{domain}", domain));
            pattern.setPattern(pattern.getPattern().replace("{name.letter}", String.valueOf(name.charAt(0))));
            pattern.setPattern(pattern.getPattern().replace("{surname.letter}", String.valueOf(name.charAt(0))));
        });

        return mailPatterns.stream().map(MailPattern::getPattern).collect(Collectors.toList());
    }

    public OneMailResponse checkOne(String mail){
        String result = CheckMailUtils.isAddressValid(mail);
        if (result.equals("Deliverable") &&
                CheckMailUtils.isAddressValid(RandomString.make(10)+"."+RandomString.make(10)+"@"+mail.substring(mail.indexOf("@") + 1)).equals("Deliverable"))
            return new OneMailResponse(mail, "Catch-all");
        else if (!(result.equals("Deliverable") || result.equals("Regex address is not valid")))
            return new OneMailResponse("test", CheckMailUtils.checkFromApi(mail));
        else
            return new OneMailResponse(mail, result);
    }

    public List<OneMailResponse> checkAll(String name, String surname, String domain){
        List<String> addresses = getEncodedMailAddress(name, surname, domain);
        List<OneMailResponse> result = new ArrayList<>();
        AtomicInteger valid = new AtomicInteger(0);
        AtomicInteger notValid = new AtomicInteger(0);

        addresses.parallelStream().forEach(address -> {
            String response = CheckMailUtils.isAddressValid(address);
            if (response.equals("Deliverable"))
                valid.incrementAndGet();
            else
                notValid.incrementAndGet();

            result.add(new OneMailResponse(address, response));
        });

        if (valid.get() == addresses.size())
            return Collections.singletonList(new OneMailResponse("ALL", "Catch-all"));

        if (notValid.get() == addresses.size()){
            result.clear();

            if (CheckMailUtils.checkFromApi(addresses.get(0)).equals("catch-all"))
                return Collections.singletonList(new OneMailResponse("ALL", "Catch-all"));

            addresses.parallelStream().forEach(address -> {
                String response = CheckMailUtils.checkFromApi(address);
                result.add(new OneMailResponse(address, response));
            });
        }

        return result;
    }
}
