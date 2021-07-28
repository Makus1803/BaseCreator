package com.basecreator.domain.model.team;


import javax.persistence.*;
import java.util.Objects;

@Entity(name = "mail_options")
public class MailPattern {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pattern;

    public MailPattern() {
    }

    public MailPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MailPattern that = (MailPattern) o;
        return Objects.equals(id, that.id) && Objects.equals(pattern, that.pattern);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pattern);
    }

    @Override
    public String toString() {
        return "MailPattern{" +
                "id=" + id +
                ", pattern=" + pattern +
                '}';
    }
}
