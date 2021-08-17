package com.basecreator.domain.model.client;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CsvBindByName(column = "first name")
    private String firstName;
    @CsvBindByName(column = "last name")
    private String lastName;
    @CsvBindByName(column = "position")
    private String position;
    @CsvBindByName(column = "domain")
    private String domain;
    @CsvBindByName(column = "company name")
    private String companyName;
    @CsvBindByName(column = "company")
    private String company;
    @CsvBindByName(column = "country")
    private String country;
    @CsvBindByName(column = "industry")
    private String industry;
    @CsvBindByName(column = "site")
    private String site;
    @CsvBindByName(column = "title")
    private String title;
    @CsvBindByName(column = "email address")
    private String emailAddress;
    @CsvBindByName(column = "custom field 1")
    private String customField1;
    @CsvBindByName(column = "custom field 2")
    private String customField2;
    @CsvBindByName(column = "custom field 3")
    private String customField3;
    @CsvBindByName(column = "custom field 4")
    private String customField4;
    @CsvBindByName(column = "custom field 5")
    private String customField5;
    @CsvBindByName(column = "custom field 6")
    private String customField6;
    @CsvBindByName(column = "custom field 7")
    private String customField7;
    @CsvBindByName(column = "custom field 8")
    private String customField8;

    public Client() {
    }

    public Client(String firstName, String lastName, String position, String domain, String companyName, String company, String country, String industry, String site, String title, String emailAddress, String customField1, String customField2, String customField3, String customField4, String customField5, String customField6, String customField7, String customField8) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.domain = domain;
        this.companyName = companyName;
        this.company = company;
        this.country = country;
        this.industry = industry;
        this.site = site;
        this.title = title;
        this.emailAddress = emailAddress;
        this.customField1 = customField1;
        this.customField2 = customField2;
        this.customField3 = customField3;
        this.customField4 = customField4;
        this.customField5 = customField5;
        this.customField6 = customField6;
        this.customField7 = customField7;
        this.customField8 = customField8;
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
                ", title='" + title + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", sn1='" + customField1 + '\'' +
                ", sn2='" + customField2 + '\'' +
                ", sn3='" + customField3 + '\'' +
                ", sn4='" + customField4 + '\'' +
                ", sn5='" + customField5 + '\'' +
                ", sn6='" + customField6 + '\'' +
                ", sn7='" + customField7 + '\'' +
                ", sn8='" + customField8 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id.equals(client.id) && Objects.equals(firstName, client.firstName) && Objects.equals(lastName, client.lastName) && Objects.equals(position, client.position) && Objects.equals(domain, client.domain) && Objects.equals(companyName, client.companyName) && Objects.equals(company, client.company) && Objects.equals(country, client.country) && Objects.equals(industry, client.industry) && Objects.equals(site, client.site) && Objects.equals(title, client.title) && Objects.equals(emailAddress, client.emailAddress) && Objects.equals(customField1, client.customField1) && Objects.equals(customField2, client.customField2) && Objects.equals(customField3, client.customField3) && Objects.equals(customField4, client.customField4) && Objects.equals(customField5, client.customField5) && Objects.equals(customField6, client.customField6) && Objects.equals(customField7, client.customField7) && Objects.equals(customField8, client.customField8);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, position, domain, companyName, company, country, industry, site, title, emailAddress, customField1, customField2, customField3, customField4, customField5, customField6, customField7, customField8);
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

    public String getCustomField1() {
        return customField1;
    }

    public void setCustomField1(String customField1) {
        this.customField1 = customField1;
    }

    public String getCustomField2() {
        return customField2;
    }

    public void setCustomField2(String customField2) {
        this.customField2 = customField2;
    }

    public String getCustomField3() {
        return customField3;
    }

    public void setCustomField3(String customField3) {
        this.customField3 = customField3;
    }

    public String getCustomField4() {
        return customField4;
    }

    public void setCustomField4(String customField4) {
        this.customField4 = customField4;
    }

    public String getCustomField5() {
        return customField5;
    }

    public void setCustomField5(String customField5) {
        this.customField5 = customField5;
    }

    public String getCustomField6() {
        return customField6;
    }

    public void setCustomField6(String customField6) {
        this.customField6 = customField6;
    }

    public String getCustomField7() {
        return customField7;
    }

    public void setCustomField7(String customField7) {
        this.customField7 = customField7;
    }

    public String getCustomField8() {
        return customField8;
    }

    public void setCustomField8(String customField8) {
        this.customField8 = customField8;
    }
}
