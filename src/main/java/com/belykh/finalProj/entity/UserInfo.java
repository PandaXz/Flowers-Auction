package com.belykh.finalProj.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class UserInfo {
    private Long id;
    private String login;
    private String email;
    private String firstName;
    private String lastName;
    private BigDecimal balance;

    public UserInfo(Long id, String login, String email, String firstName, String lastName, BigDecimal balance) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    public UserInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(id, userInfo.id) &&
                Objects.equals(login, userInfo.login) &&
                Objects.equals(email, userInfo.email) &&
                Objects.equals(firstName, userInfo.firstName) &&
                Objects.equals(lastName, userInfo.lastName) &&
                Objects.equals(balance, userInfo.balance);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login, email, firstName, lastName, balance);
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", money=" + balance +
                '}';
    }
}
