package com.example.marcell.webapichallenge.entity;

import com.example.marcell.webapichallenge.enumeration.SkillLevel;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.Objects;
import java.util.Set;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private SkillLevel skillLevel;

    @ManyToMany(mappedBy = "skills")
    private Set<Contact> contacts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(EnumType.STRING)
    public SkillLevel getLevel() {
        return skillLevel;
    }

    public void setLevel(SkillLevel level) {
        this.skillLevel = level;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContacts(Set<Contact> contacts){
        this.contacts.addAll(contacts);
    }

    public void removeContacts(Set<Contact> contacts){
        this.contacts.removeAll(contacts);
    }

    public int countContacts(){
        return this.contacts.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Skill skill = (Skill) o;

        if (!Objects.equals(id, skill.id)) return false;
        if (!Objects.equals(name, skill.name)) return false;
        if (!Objects.equals(skillLevel, skill.skillLevel)) return false;
        return Objects.equals(contacts, skill.contacts);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (skillLevel != null ? skillLevel.hashCode() : 0);
        result = 31 * result + (contacts != null ? contacts.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level='" + skillLevel + '\'' +
                ", contacts=" + contacts +
                '}';
    }
}
