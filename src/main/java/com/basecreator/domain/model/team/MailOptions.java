package com.basecreator.domain.model.team;


import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity(name = "mail_options")
public class MailOptions {
    @Id
    private Long id;

    @ElementCollection
    private List<String> mailOption;

    public MailOptions() {
    }

    public MailOptions(List<String> mailOption) {
        this.mailOption = mailOption;
    }

    public List<String> getMailOption() {
        return mailOption;
    }

    public void setMailOption(List<String> mailOption) {
        this.mailOption = mailOption;
    }

    public void addOption(String option){
        this.mailOption.add(option);
    }

    public List<String> getEncodedMailAddress(String name, String surname, String domain){

        return mailOption.stream().map(option -> {

            option = option.replace("{name}", name);
            option = option.replace("{surname}", surname);
            option = option.replace("{domain}", domain);
            option = option.replace("{name.letter}", String.valueOf(name.charAt(0)));
            option = option.replace("{surname.letter}", String.valueOf(name.charAt(0)));

            return option;
        }).collect(Collectors.toList());
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailOptions that = (MailOptions) o;
        return Objects.equals(id, that.id) && Objects.equals(mailOption, that.mailOption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mailOption);
    }

    @Override
    public String toString() {
        return "MailOptions{" +
                "id=" + id +
                ", mailOption=" + mailOption +
                '}';
    }
}
