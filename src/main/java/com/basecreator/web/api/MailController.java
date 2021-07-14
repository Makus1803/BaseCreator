package com.basecreator.web.api;

import com.basecreator.domain.model.team.MailOptions;
import com.basecreator.domain.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/mail")
public class MailController {
    @Autowired
    MailService mailService;

    @PostMapping("/add/option")
    public MailOptions addMail(MailOptions mailOptions){

        return mailService.save(mailOptions);
    }



}
