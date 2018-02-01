package com.belykh.finalProj.entity.dbo;

import java.math.BigDecimal;

/**
 * Created by panda on 6.1.18.
 */
public class UserDBO {
    private Long id;
    private String login;
    private String pass;
    private String email;
    private String firstName;
    private String lastName;
    private int role;
    private BigDecimal balance;

    public UserDBO(Long id, String login, String pass, String email, String firstName, String lastName, int role, BigDecimal balance) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.balance = balance;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
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

        UserDBO userDBO = (UserDBO) o;

        if (role != userDBO.role) return false;
        if (!id.equals(userDBO.id)) return false;
        if (!login.equals(userDBO.login)) return false;
        if (!pass.equals(userDBO.pass)) return false;
        if (!email.equals(userDBO.email)) return false;
        if (firstName != null ? !firstName.equals(userDBO.firstName) : userDBO.firstName != null) return false;
        if (lastName != null ? !lastName.equals(userDBO.lastName) : userDBO.lastName != null) return false;
        return balance.equals(userDBO.balance);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + pass.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + role;
        result = 31 * result + balance.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserDBO{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                ", money=" + balance +
                '}';
    }
}
