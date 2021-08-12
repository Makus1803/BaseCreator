package com.basecreator.domain.model.mail;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Entity
@Table(name = "message_pattern",
        uniqueConstraints ={
                @UniqueConstraint(columnNames = "name")
        })
public class MessagePattern {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String pattern;

    @ElementCollection(targetClass=String.class)
    @MapKeyColumn(name="message_keys")
    private Map<EMessageKeys, String> messageValueMap = new HashMap<>();

    public MessagePattern() {
    }

    public MessagePattern(String pattern, String name) {
        this.name = name;
        this.pattern = pattern;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MessagePattern{" +
                "id=" + id +
                ", pattern='" + pattern + '\'' +
                ", mailValueMap=" + messageValueMap +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessagePattern that = (MessagePattern) o;
        return Objects.equals(id, that.id) && Objects.equals(pattern, that.pattern) && Objects.equals(messageValueMap, that.messageValueMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pattern, messageValueMap);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public Map<EMessageKeys, String> getMessageValueMap() {
        return messageValueMap;
    }

    public void setMessageValueMap(Map<EMessageKeys, String> messageValueMap) {
        this.messageValueMap = messageValueMap;
    }
}
