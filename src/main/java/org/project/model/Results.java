package org.project.model;


import jakarta.persistence.*;

/**
 * 09/02/2022
 */

@Entity
public class Results {
    @Id
    private String email;
    private int totalScore;


    public Results() {
        super();
    }


    public Results(String email, int totalScore) {
        super();
        this.email = email;
        this.totalScore = totalScore;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public int getTotalScore() {
        return totalScore;
    }


    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }



}
