package com.jatin.checker_website.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String movieName;

    private boolean hasJatinWatched;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public boolean isHasJatinWatched() {
        return hasJatinWatched;
    }

    public void setHasJatinWatched(boolean hasJatinWatched) {
        this.hasJatinWatched = hasJatinWatched;
    }

    public Movie(String movieName, boolean hasJatinWatched) {
        this.movieName = movieName;
        this.hasJatinWatched = hasJatinWatched;
    }

    public Movie(){

    }
}
