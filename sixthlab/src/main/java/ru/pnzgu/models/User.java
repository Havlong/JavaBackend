package ru.pnzgu.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Objects;

/**
 * 28.09.2019
 * User
 *
 * @author havlong
 * @version 1.0
 */
@JsonAutoDetect
public class User {
    private String userName;
    private String password;
    private String name;
    private String surname;
    private String car;

    public User(String userName, String password, String name, String surname, String car) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.car = car;
    }

    public User() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getUserName().equals(user.getUserName()) &&
                getPassword().equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName(), getPassword());
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }
}
