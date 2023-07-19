package com.example.marcell.webapichallenge.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.Objects;
import java.util.Set;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String fullName;
    private String address;
    private String email;
    private String mobilePhoneNumber;

    @ManyToMany(cascade = {CascadeType.ALL /* ALL, since any skill is always tied to a single contact, we want to cascade every operation. */})
    @JoinTable(
            name = "contact_skill",
            joinColumns = @JoinColumn(name = "contact_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id"))
    private Set<Skill> skills;

    public Contact(Long id, String firstName, String lastName, String fullName, String address, String email, String mobilePhoneNumber, Set<Skill> skills) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.skills = skills;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        if (!Objects.equals(id, contact.id)) return false;
        if (!Objects.equals(firstName, contact.firstName)) return false;
        if (!Objects.equals(lastName, contact.lastName)) return false;
        if (!Objects.equals(fullName, contact.fullName)) return false;
        if (!Objects.equals(address, contact.address)) return false;
        if (!Objects.equals(email, contact.email)) return false;
        if (!Objects.equals(mobilePhoneNumber, contact.mobilePhoneNumber))
            return false;
        return Objects.equals(skills, contact.skills);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (mobilePhoneNumber != null ? mobilePhoneNumber.hashCode() : 0);
        result = 31 * result + (skills != null ? skills.hashCode() : 0);
        return result;
    }


}
