package com.basecreator.utils;

import com.basecreator.domain.model.client.Client;
import com.basecreator.domain.model.mail.EMessageKeys;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;
public class MailUtils {
    public static String decodeMessage(Map<EMessageKeys, String> messageKey, Client client, String message){
        if (!StringUtils.isEmpty(client.getFirstName()) && !StringUtils.isEmpty(messageKey.get(EMessageKeys.MESSAGE_KEYS_firstName)))
            message = message.replace(messageKey.get(EMessageKeys.MESSAGE_KEYS_firstName), client.getFirstName());

        if (!StringUtils.isEmpty(client.getLastName()) && !StringUtils.isEmpty(messageKey.get(EMessageKeys.MESSAGE_KEYS_lastName)))
            message = message.replace(messageKey.get(EMessageKeys.MESSAGE_KEYS_lastName), client.getLastName());

        if (client.getPosition() != null && !StringUtils.isEmpty(messageKey.get(EMessageKeys.MESSAGE_KEYS_position)))
            message = message.replace(messageKey.get(EMessageKeys.MESSAGE_KEYS_position), client.getPosition());

        if (client.getDomain() != null && !StringUtils.isEmpty(messageKey.get(EMessageKeys.MESSAGE_KEYS_domain)))
            message = message.replace(messageKey.get(EMessageKeys.MESSAGE_KEYS_domain), client.getDomain());

        if (client.getCompanyName() != null && !StringUtils.isEmpty(messageKey.get(EMessageKeys.MESSAGE_KEYS_companyName)))
            message = message.replace(messageKey.get(EMessageKeys.MESSAGE_KEYS_companyName), client.getCompanyName());

        if (client.getCompany() != null && !StringUtils.isEmpty(messageKey.get(EMessageKeys.MESSAGE_KEYS_company)))
            message = message.replace(messageKey.get(EMessageKeys.MESSAGE_KEYS_company), client.getCompany());

        if (client.getCountry() != null && !StringUtils.isEmpty(messageKey.get(EMessageKeys.MESSAGE_KEYS_country)))
            message = message.replace(messageKey.get(EMessageKeys.MESSAGE_KEYS_country), client.getCountry());

        if (client.getIndustry() != null && !StringUtils.isEmpty(messageKey.get(EMessageKeys.MESSAGE_KEYS_industry)))
            message = message.replace(messageKey.get(EMessageKeys.MESSAGE_KEYS_industry), client.getIndustry());

        if (client.getSite() != null && !StringUtils.isEmpty(messageKey.get(EMessageKeys.MESSAGE_KEYS_site)))
            message = message.replace(messageKey.get(EMessageKeys.MESSAGE_KEYS_site), client.getSite());

        if (client.getTitle() != null && !StringUtils.isEmpty(messageKey.get(EMessageKeys.MESSAGE_KEYS_title)))
            message = message.replace(messageKey.get(EMessageKeys.MESSAGE_KEYS_title), client.getTitle());

        if (client.getEmailAddress() != null && !StringUtils.isEmpty(messageKey.get(EMessageKeys.MESSAGE_KEYS_emailAddress)))
            message = message.replace(messageKey.get(EMessageKeys.MESSAGE_KEYS_emailAddress), client.getEmailAddress());

        if (client.getCustomField1() != null && !StringUtils.isEmpty(messageKey.get(EMessageKeys.MESSAGE_KEYS_customField1)))
            message = message.replace(messageKey.get(EMessageKeys.MESSAGE_KEYS_customField1), client.getCustomField1());

        if (client.getCustomField2() != null && !StringUtils.isEmpty(messageKey.get(EMessageKeys.MESSAGE_KEYS_customField2)))
            message = message.replace(messageKey.get(EMessageKeys.MESSAGE_KEYS_customField2), client.getCustomField2());

        if (client.getCustomField3() != null && !StringUtils.isEmpty(messageKey.get(EMessageKeys.MESSAGE_KEYS_customField3)))
            message = message.replace(messageKey.get(EMessageKeys.MESSAGE_KEYS_customField3), client.getCustomField3());

        if (client.getCustomField4() != null && !StringUtils.isEmpty(messageKey.get(EMessageKeys.MESSAGE_KEYS_customField4)))
            message = message.replace(messageKey.get(EMessageKeys.MESSAGE_KEYS_customField4), client.getCustomField4());

        if (client.getCustomField5() != null && !StringUtils.isEmpty(messageKey.get(EMessageKeys.MESSAGE_KEYS_customField5)))
            message = message.replace(messageKey.get(EMessageKeys.MESSAGE_KEYS_customField5), client.getCustomField5());

        if (client.getCustomField6() != null && !StringUtils.isEmpty(messageKey.get(EMessageKeys.MESSAGE_KEYS_customField6)))
            message = message.replace(messageKey.get(EMessageKeys.MESSAGE_KEYS_customField6), client.getCustomField6());

        if (client.getCustomField7() != null && !StringUtils.isEmpty(messageKey.get(EMessageKeys.MESSAGE_KEYS_customField7)))
            message = message.replace(messageKey.get(EMessageKeys.MESSAGE_KEYS_customField7), client.getCustomField7());

        if (client.getCustomField8() != null && !StringUtils.isEmpty(messageKey.get(EMessageKeys.MESSAGE_KEYS_customField8)))
            message = message.replace(messageKey.get(EMessageKeys.MESSAGE_KEYS_customField8), client.getCustomField8());

        return message;
    }

    public static Map<EMessageKeys, String> addToMap(Map<EMessageKeys, String> map,String key, String value){
        switch (key){
            case "firstName":
                map.put(EMessageKeys.MESSAGE_KEYS_firstName, value);
                break;
            case "lastName":
                map.put(EMessageKeys.MESSAGE_KEYS_lastName, value);
                break;
            case "position":
                map.put(EMessageKeys.MESSAGE_KEYS_position, value);
                break;
            case "domain":
                map.put(EMessageKeys.MESSAGE_KEYS_domain, value);
                break;
            case "companyName":
                map.put(EMessageKeys.MESSAGE_KEYS_companyName, value);
                break;
            case "company":
                map.put(EMessageKeys.MESSAGE_KEYS_company, value);
                break;
            case "country":
                map.put(EMessageKeys.MESSAGE_KEYS_country, value);
                break;
            case "industry":
                map.put(EMessageKeys.MESSAGE_KEYS_industry, value);
                break;
            case "site":
                map.put(EMessageKeys.MESSAGE_KEYS_site, value);
                break;
            case "nip":
                map.put(EMessageKeys.MESSAGE_KEYS_nip, value);
                break;
            case "title":
                map.put(EMessageKeys.MESSAGE_KEYS_title, value);
                break;
            case "emailAddress":
                map.put(EMessageKeys.MESSAGE_KEYS_emailAddress, value);
                break;
            case "sn1":
                map.put(EMessageKeys.MESSAGE_KEYS_customField1, value);
                break;
            case "sn2":
                map.put(EMessageKeys.MESSAGE_KEYS_customField2, value);
                break;
            case "sn3":
                map.put(EMessageKeys.MESSAGE_KEYS_customField3, value);
                break;
            case "sn4":
                map.put(EMessageKeys.MESSAGE_KEYS_customField4, value);
                break;
            case "sn5":
                map.put(EMessageKeys.MESSAGE_KEYS_customField5, value);
                break;
            case "sn6":
                map.put(EMessageKeys.MESSAGE_KEYS_customField6, value);
                break;
            case "sn7":
                map.put(EMessageKeys.MESSAGE_KEYS_customField7, value);
                break;
            case "sn8":
                map.put(EMessageKeys.MESSAGE_KEYS_customField8, value);
                break;
            default:
                return map;
        }
        return map;
    }
}
