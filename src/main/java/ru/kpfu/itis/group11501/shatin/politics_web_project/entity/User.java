package ru.kpfu.itis.group11501.shatin.politics_web_project.entity;

import org.hibernate.annotations.SortNatural;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Collection;
import java.util.SortedSet;

/**
 * By @author Oleg Shatin
 * Date: 3/17/17 1:28 PM
 */

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    private int id;
    private String name;
    @Column
    private String surname;
    @Column
    private String patronymic;
    private String email;
    private String passwordRaw;
    private String passwordHash;
    @Column
    private LocalDate birthday;
    @Column
    private ZoneOffset timezoneOffset;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "user")
    @SortNatural
    private SortedSet<Comment> comments;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "sender")
    @SortNatural
    private SortedSet<Message> sentMessages;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "recipient")
    @SortNatural
    private SortedSet<Message> recipiedMessages;
    @OneToOne(mappedBy = "agent")
    private Candidate candidate;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public SortedSet<Comment> getComments() {
        return comments;
    }

    public void setComments(SortedSet<Comment> comments) {
        this.comments = comments;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public ZoneOffset getTimezoneOffset() {
        return timezoneOffset;
    }

    public void setTimezoneOffset(ZoneOffset timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
    }

    private UserRole role;

    private boolean active = true;


    public User() {}

    public User(String name, String email, String passwordHash, String role) {
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "email", unique = true, nullable = false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Column(name = "password_hash", nullable = false)
    public String getPasswordHash() {
        return passwordHash;
    }
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }



    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Column(name = "active", nullable = false)
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }



    @Transient
    public String getPasswordRaw() {
        return passwordRaw;
    }

    public void setPasswordRaw(String passwordRaw) {
        this.passwordRaw = passwordRaw;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return id == user.getId() && email.equals(user.getEmail());
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + email.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return String.format("User[id=%d; name=%s; email=%s;]", id, name, email);
    }
}
