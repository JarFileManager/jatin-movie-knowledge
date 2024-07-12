package com.jatin.checker_website.controllers;

import com.jatin.checker_website.models.MovieRequest;
import com.jatin.checker_website.service.MovieService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.web.server.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private MovieService movieService;


    @RequestMapping("submission-handler")
    public String createRequest(@RequestParam String movieName, Model model){

        model.addAttribute("registered", movieService.saveToDB(movieName));

        return "index";
    }

    @RequestMapping("request-handler")
    public String showRequests(Model model){
        List<MovieRequest> movieRequests = movieService.showAllRequests();
        model.addAttribute("movieRequests", movieRequests);
        return "movie-requests";
    }

}
