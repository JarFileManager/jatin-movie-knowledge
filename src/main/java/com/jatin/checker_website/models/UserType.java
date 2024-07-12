package com.jatin.checker_website.models;

import com.jatin.checker_website.utils.Relation;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

//@Entity
public class UserType {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userName;

    private Relation relation;

    private boolean isAdmin;

    private List<MovieRequest> movieRequests;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Relation getRelation() {
        return relation;
    }

    public void setRelation(Relation relation) {
        this.relation = relation;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public List<MovieRequest> getMovieRequests() {
        return movieRequests;
    }

    public void setMovieRequests(List<MovieRequest> movieRequests) {
        this.movieRequests = movieRequests;
    }
}
