package com.jatin.checker_website.models;

import com.jatin.checker_website.utils.Status;
import jakarta.persistence.*;

@Entity
public class MovieRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String requestId;

    @OneToOne
    private Movie movie;

    private Status status;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String requestId) {
        this.requestId = requestId;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getRequestId() {
        return requestId;
    }

    public Movie getMovie() {
        return movie;
    }

    public Status getStatus() {
        return status;
    }

    public MovieRequest(String requestId, Movie movie, Status status) {
        this.requestId = requestId;
        this.movie = movie;
        this.status = status;
    }

    public MovieRequest(){

    }
}
