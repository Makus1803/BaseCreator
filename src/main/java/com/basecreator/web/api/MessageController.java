package com.basecreator.web.api;

import com.basecreator.domain.model.mail.EMessageKeys;
import com.basecreator.domain.model.mail.MessagePattern;
import com.basecreator.domain.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/mail")
public class MessageController {
    @Autowired
    private MailService mailService;

    @GetMapping("/pattern/all")
    public List<MessagePattern> getAllMessagePatterns() {
        return mailService.getAllMessagePatterns();
    }

    @PostMapping("/pattern/add")
    public MessagePattern addMessagePattern(String name, String pattern) {
        MessagePattern messagePattern = new MessagePattern(name, pattern);
        return mailService.save(messagePattern);
    }

    @PostMapping("/value-map/add")
    public MessagePattern addValueMap(String patternName, String key, String value) {
        return mailService.addMapToPattern(patternName, key, value);
    }

    @PostMapping("/value-map/get")
    public Map<EMessageKeys, String> getValueMap(String patterName){
        return mailService.getMessageValueMap(patterName);
    }

    @PostMapping("/pattern/decode")
    public String decodePattern(String patternName, String clientNip){
        return mailService.decodeMessagePattern(patternName, clientNip);
    }

    @PostMapping("/pattern/decode-all")
    public List<String> decodeAllPattern(String patternName){
        return mailService.decodeAllMessagePattern(patternName);
    }
}
