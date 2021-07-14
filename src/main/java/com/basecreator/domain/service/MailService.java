package com.basecreator.domain.service;

import com.basecreator.domain.model.team.MailOptions;
import com.basecreator.domain.model.team.MailOptionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    @Autowired
    private MailOptionsRepository mailOptionsRepository;

    public MailOptions save(MailOptions mailOptions){
        return mailOptionsRepository.save(mailOptions);
    }

    public MailOptions addOption(MailOptions mailOptions, String option){
        mailOptions.addOption(option);

        return mailOptionsRepository.save(mailOptions);
    }
}
