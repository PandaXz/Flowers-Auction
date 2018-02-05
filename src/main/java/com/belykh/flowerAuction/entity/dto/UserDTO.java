package com.belykh.flowerAuction.entity.dto;

import java.math.BigDecimal;

/**
 * The Class UserDTO.
 */
public class UserDTO {
    private Long id;
    private String login;
    private String pass;
    private String email;
    private String firstName;
    private String lastName;
    private int role;
    private BigDecimal balance;

    /**
     * Instantiates a new user DTO.
     *
     * @param id the id
     * @param login the login
     * @param pass the pass
     * @param email the email
     * @param firstName the first name
     * @param lastName the last name
     * @param role the role
     * @param balance the balance
     */
    public UserDTO(Long id, String login, String pass, String email, String firstName, String lastName, int role, BigDecimal balance) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.balance = balance;
    }

    /**
     * Instantiates a new user DTO.
     */
    public UserDTO() {
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the login.
     *
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the login.
     *
     * @param login the new login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Gets the pass.
     *
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * Sets the pass.
     *
     * @param pass the new pass
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the role.
     *
     * @return the role
     */
    public int getRole() {
        return role;
    }

    /**
     * Sets the role.
     *
     * @param role the new role
     */
    public void setRole(int role) {
        this.role = role;
    }

    /**
     * Gets the balance.
     *
     * @return the balance
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * Sets the balance.
     *
     * @param balance the new balance
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDTO userDTO = (UserDTO) o;

        if (role != userDTO.role) return false;
        if (!id.equals(userDTO.id)) return false;
        if (!login.equals(userDTO.login)) return false;
        if (!pass.equals(userDTO.pass)) return false;
        if (!email.equals(userDTO.email)) return false;
        if (firstName != null ? !firstName.equals(userDTO.firstName) : userDTO.firstName != null) return false;
        if (lastName != null ? !lastName.equals(userDTO.lastName) : userDTO.lastName != null) return false;
        return balance.equals(userDTO.balance);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
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

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                ", balance=" + balance +
                '}';
    }
}
