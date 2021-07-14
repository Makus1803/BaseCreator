package com.basecreator.domain.model.client;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

//@Entity
public class Client {

//    @Id
    private long id;

    private String firstName;
    private String lastName;
    private String position;
    private String domain;
    private String companyName;
    private String company;
    private String country;
    private String industry;
    private String site;
    private String nip;
    private String title;
    private List<String> emailAddress;
    private String sn1;
    private String sn2;
    private String sn3;
    private String sn4;
    private String sn5;
    private String sn6;
    private String sn7;
    private String sn8;

    public Client(long id, String firstName, String lastName, String position, String domain, String companyName, String company, String country, String industry, String site, String nip, String title, String emailAddress, String sn1, String sn2, String sn3, String sn4, String sn5, String sn6, String sn7, String sn8) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.domain = domain;
        this.companyName = companyName;
        this.company = company;
        this.country = country;
        this.industry = industry;
        this.site = site;
        this.nip = nip;
        this.title = title;

//        this.emailAddress = emailAddress;

        this.sn1 = sn1;
        this.sn2 = sn2;
        this.sn3 = sn3;
        this.sn4 = sn4;
        this.sn5 = sn5;
        this.sn6 = sn6;
        this.sn7 = sn7;
        this.sn8 = sn8;
    }


}
