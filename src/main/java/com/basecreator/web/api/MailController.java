package com.basecreator.web.api;

import com.basecreator.domain.model.mail.MailPattern;
import com.basecreator.domain.service.MailService;
import com.basecreator.web.payload.response.OneMailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/mail")
public class MailController {
    @Autowired
    MailService mailService;

    @PostMapping("/add/option")
    public MailPattern addMail(MailPattern mailPattern) {

        return mailService.save(mailPattern);
    }

    @GetMapping("/get/all-pattern")
    public List<MailPattern> getAllMailPattern() {
        return mailService.getAllMailPattern();
    }

    @PostMapping("/get/decoded-pattern")
    public List<String> getAllDecodedPattern(String name, String surname, String domain) {
        return mailService.getDecodedMailAddress(name, surname, domain);
    }

    @PostMapping("/check/one-mail")
    public OneMailResponse checkOneMail(String mailAddress) {
        return mailService.checkOne(mailAddress);
    }

    @PostMapping("/check/all-mails")
    public List<OneMailResponse> checkAllMails(String name, String surname, String domain) {
        return mailService.checkAll(name, surname, domain);
    }

}
