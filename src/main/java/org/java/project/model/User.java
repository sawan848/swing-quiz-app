package org.java.project.model;

import jakarta.persistence.*;

/**
 * 09/02/2022
 *
 */

@Entity
public class User {
    @Column(name = "id" ,columnDefinition = "BIGINT(20) NOT NULL UNIQUE KEY auto_increment")
    private int id;
    private String username;
    @Id
    private String email;
    private String password;
    @Transient
    private String confirmPassword;
    private String userType;

    public int getId() {
        return id;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }
}
