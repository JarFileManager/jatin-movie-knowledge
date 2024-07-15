package com.jatin.checker_website.controllers;

import com.jatin.checker_website.models.MovieRequest;
import com.jatin.checker_website.service.MailService;
import com.jatin.checker_website.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private MovieService movieService;

    @Value("${spring.mail.username}")
    private String adminMail;

    @Autowired
    private MailService mailService;


    @RequestMapping("submission-handler")
    public String createRequest(@RequestParam String movieName, Model model){

        boolean requestRegistered = movieService.saveToDB(movieName);

        model.addAttribute("registered", requestRegistered );
        if(requestRegistered){
            mailService.sendEmail(adminMail, "Movie Mail!!", movieName);
        }

        return "index";
    }

    @RequestMapping("request-handler")
    public String showRequests(Model model){
        List<MovieRequest> movieRequests = movieService.showAllRequests();
        model.addAttribute("movieRequests", movieRequests);
        return "movie-requests";
    }

}
