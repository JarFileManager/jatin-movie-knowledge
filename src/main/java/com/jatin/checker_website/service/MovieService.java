package com.jatin.checker_website.service;

import com.jatin.checker_website.models.Movie;
import com.jatin.checker_website.models.MovieRequest;
import com.jatin.checker_website.repository.MovieRepository;
import com.jatin.checker_website.repository.MovieRequestRepository;
import com.jatin.checker_website.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieService {

    @Autowired
    private MovieRequestRepository movieRequestRepository;

    @Autowired
    private MovieRepository movieRepository;

    public boolean saveToDB(String movieName){
        MovieRequest movieRequest;
        if(movieRepository.findByMovieName(movieName).isPresent()){
            Optional<MovieRequest> mR = moviePresentInRequests(movieName);
            if(mR.isPresent()){
                return false;
            }
            movieRequest = new MovieRequest(generateRequestId(),movieRepository.findByMovieName(movieName).get(), Status.IN_PROGRESS);
        } else{
            Movie movie = new Movie(movieName, false);
            movieRepository.save(movie);
            movieRequest = new MovieRequest(generateRequestId(), movie, Status.REGISTERED);
        }
        movieRequestRepository.save(movieRequest);

        return true;
    }

    public List<MovieRequest> showAllRequests(){
        return movieRequestRepository.findAll();
    }


    public List<MovieRequest> getAllCompletedRequests(){
        return movieRequestRepository.findAll().stream().filter(x -> x.getStatus().equals(Status.COMPLETED)).toList();
    }

    public List<MovieRequest> getAllPendingRequests(){
        return movieRequestRepository.findAll().stream().filter(x -> x.getStatus().equals(Status.REGISTERED)).toList();
    }


    public String generateRequestId(){
        return UUID.randomUUID().toString().split("-")[0];
    }

    public Optional<MovieRequest> moviePresentInRequests(String movieName){
        return movieRequestRepository.findAll().stream().filter(x -> x.getMovie().getMovieName().equals(movieName)).findFirst();
    }

    public void updateMovieStatus(String movieName, String watchedIt){
        Movie movie = movieRepository.findByMovieName(movieName).get();
        boolean hasJatinWatched = watchedIt.equals("true");
        movie.setHasJatinWatched(hasJatinWatched);
        movieRepository.save(movie);

        MovieRequest movieRequest = movieRequestRepository.findByMovie(movie).get();
        movieRequest.setStatus(Status.COMPLETED);

        //MovieRequest movieRequest = movieRequestRepository.findAll().stream().filter(x->x.getMovie().getMovieName().equals(movieName)).findFirst().get();
        movieRequestRepository.save(movieRequest);
    }
}
