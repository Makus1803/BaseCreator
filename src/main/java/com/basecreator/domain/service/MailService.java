package com.basecreator.domain.service;

import com.basecreator.domain.model.client.Client;
import com.basecreator.domain.model.client.ClientRepository;
import com.basecreator.domain.model.mail.*;
import com.basecreator.utils.CheckMailUtils;
import com.basecreator.utils.MailUtils;
import com.basecreator.web.payload.response.OneMailResponse;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class MailService {
    @Autowired
    private MailPatternRepository mailPatternRepository;
    @Autowired
    private MessagePatternRepository messagePatternRepository;
    @Autowired
    private ClientRepository clientRepository;

    public MessagePattern save(MessagePattern messagePattern) {
        return messagePatternRepository.save(messagePattern);
    }

    public List<MessagePattern> getAllMessagePatterns() {
        return messagePatternRepository.findAll();
    }

    public MessagePattern addMapToPattern(String messagePatternName, String key, String value) {
        MessagePattern messagePattern = messagePatternRepository.findByName(messagePatternName);
        Map<EMessageKeys, String> map = messagePattern.getMessageValueMap();
        MailUtils.addToMap(map, key, value);

        messagePattern.setMessageValueMap(map);
        return messagePatternRepository.save(messagePattern);
    }

    public String decodeMessagePattern(String patternName, String clientNip){
        MessagePattern messagePattern = messagePatternRepository.findByName(patternName);
        String message = messagePattern.getPattern();
        Map<EMessageKeys, String> patternMap = messagePattern.getMessageValueMap();

        Client client = clientRepository.findByNip(clientNip);

        return message.replace(patternMap.get(EMessageKeys.MESSAGE_KEYS_firstName), client.getFirstName());
    }

    public Map<EMessageKeys, String> getMessageValueMap(String messagePatternName) {
        return messagePatternRepository.findByName(messagePatternName).getMessageValueMap();

    }

    /* --- Mail pattern --- */

    public MailPattern save(MailPattern mailPattern) {
        return mailPatternRepository.save(mailPattern);
    }

    public List<MailPattern> getAllMailPattern() {
        return mailPatternRepository.findAll();
    }

    public List<String> getEncodedMailAddress(String name, String surname, String domain) {
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

    public OneMailResponse checkOne(String mail) {
        String result = CheckMailUtils.isAddressValid(mail);
        if (result.equals("Deliverable") &&
                CheckMailUtils.isAddressValid(RandomString.make(10) + "." + RandomString.make(10) + "@" + mail.substring(mail.indexOf("@") + 1)).equals("Deliverable"))
            return new OneMailResponse(mail, "Catch-all");
        else if (!(result.equals("Deliverable") || result.equals("Regex address is not valid")))
            return new OneMailResponse("test", CheckMailUtils.checkFromApi(mail));
        else
            return new OneMailResponse(mail, result);
    }

    public List<OneMailResponse> checkAll(String name, String surname, String domain) {
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

        if (notValid.get() == addresses.size()) {
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
