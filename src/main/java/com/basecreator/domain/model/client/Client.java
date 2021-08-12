package com.basecreator.domain.model.client;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Objects;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    private String emailAddress;
    private String sn1;
    private String sn2;
    private String sn3;
    private String sn4;
    private String sn5;
    private String sn6;
    private String sn7;
    private String sn8;

    public Client() {
    }

    public Client(String firstName, String lastName, String position, String domain, String companyName, String company, String country, String industry, String site, String nip, String title, String emailAddress, String sn1, String sn2, String sn3, String sn4, String sn5, String sn6, String sn7, String sn8) {
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
        this.emailAddress = emailAddress;
        this.sn1 = sn1;
        this.sn2 = sn2;
        this.sn3 = sn3;
        this.sn4 = sn4;
        this.sn5 = sn5;
        this.sn6 = sn6;
        this.sn7 = sn7;
        this.sn8 = sn8;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", domain='" + domain + '\'' +
                ", companyName='" + companyName + '\'' +
                ", company='" + company + '\'' +
                ", country='" + country + '\'' +
                ", industry='" + industry + '\'' +
                ", site='" + site + '\'' +
                ", nip='" + nip + '\'' +
                ", title='" + title + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", sn1='" + sn1 + '\'' +
                ", sn2='" + sn2 + '\'' +
                ", sn3='" + sn3 + '\'' +
                ", sn4='" + sn4 + '\'' +
                ", sn5='" + sn5 + '\'' +
                ", sn6='" + sn6 + '\'' +
                ", sn7='" + sn7 + '\'' +
                ", sn8='" + sn8 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id.equals(client.id) && Objects.equals(firstName, client.firstName) && Objects.equals(lastName, client.lastName) && Objects.equals(position, client.position) && Objects.equals(domain, client.domain) && Objects.equals(companyName, client.companyName) && Objects.equals(company, client.company) && Objects.equals(country, client.country) && Objects.equals(industry, client.industry) && Objects.equals(site, client.site) && Objects.equals(nip, client.nip) && Objects.equals(title, client.title) && Objects.equals(emailAddress, client.emailAddress) && Objects.equals(sn1, client.sn1) && Objects.equals(sn2, client.sn2) && Objects.equals(sn3, client.sn3) && Objects.equals(sn4, client.sn4) && Objects.equals(sn5, client.sn5) && Objects.equals(sn6, client.sn6) && Objects.equals(sn7, client.sn7) && Objects.equals(sn8, client.sn8);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, position, domain, companyName, company, country, industry, site, nip, title, emailAddress, sn1, sn2, sn3, sn4, sn5, sn6, sn7, sn8);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getSn1() {
        return sn1;
    }

    public void setSn1(String sn1) {
        this.sn1 = sn1;
    }

    public String getSn2() {
        return sn2;
    }

    public void setSn2(String sn2) {
        this.sn2 = sn2;
    }

    public String getSn3() {
        return sn3;
    }

    public void setSn3(String sn3) {
        this.sn3 = sn3;
    }

    public String getSn4() {
        return sn4;
    }

    public void setSn4(String sn4) {
        this.sn4 = sn4;
    }

    public String getSn5() {
        return sn5;
    }

    public void setSn5(String sn5) {
        this.sn5 = sn5;
    }

    public String getSn6() {
        return sn6;
    }

    public void setSn6(String sn6) {
        this.sn6 = sn6;
    }

    public String getSn7() {
        return sn7;
    }

    public void setSn7(String sn7) {
        this.sn7 = sn7;
    }

    public String getSn8() {
        return sn8;
    }

    public void setSn8(String sn8) {
        this.sn8 = sn8;
    }
}
