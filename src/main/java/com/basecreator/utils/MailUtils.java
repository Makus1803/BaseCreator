package com.basecreator.utils;

import com.basecreator.domain.model.mail.EMessageKeys;

import java.util.Map;

public class MailUtils {
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
                map.put(EMessageKeys.MESSAGE_KEYS_sn1, value);
                break;
            case "sn2":
                map.put(EMessageKeys.MESSAGE_KEYS_sn2, value);
                break;
            case "sn3":
                map.put(EMessageKeys.MESSAGE_KEYS_sn3, value);
                break;
            case "sn4":
                map.put(EMessageKeys.MESSAGE_KEYS_sn4, value);
                break;
            case "sn5":
                map.put(EMessageKeys.MESSAGE_KEYS_sn5, value);
                break;
            case "sn6":
                map.put(EMessageKeys.MESSAGE_KEYS_sn6, value);
                break;
            case "sn7":
                map.put(EMessageKeys.MESSAGE_KEYS_sn7, value);
                break;
            case "sn8":
                map.put(EMessageKeys.MESSAGE_KEYS_sn8, value);
                break;
            default:
                return map;
        }
        return map;
    }
}
