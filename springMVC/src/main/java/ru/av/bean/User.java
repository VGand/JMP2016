package ru.av.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Полина on 22.09.2016.
 */
public class User {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date birthDay;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
