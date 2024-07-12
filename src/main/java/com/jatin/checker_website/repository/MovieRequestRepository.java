package com.jatin.checker_website.repository;

import com.jatin.checker_website.models.Movie;
import com.jatin.checker_website.models.MovieRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRequestRepository extends JpaRepository<MovieRequest, Integer> {

    Optional<MovieRequest> findByMovie(Movie movie);
}
