package com.jatin.checker_website.controllers;

import com.jatin.checker_website.models.MovieRequest;
import com.jatin.checker_website.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("/admin")
    public String adminHomePage(){
        return "admin-home";
    }

    @RequestMapping("completed-requests")
    public String showCompletedRequests(Model model){
        List<MovieRequest> movieRequestList = movieService.getAllCompletedRequests();
        model.addAttribute("movieRequests", movieRequestList);
        model.addAttribute("showToggleButton", false);
        return "show-requests";
    }

    @RequestMapping("pending-requests")
    public String showPendingRequests(Model model){
        List<MovieRequest> movieRequestList = movieService.getAllPendingRequests();
        model.addAttribute("movieRequests", movieRequestList);
        model.addAttribute("showToggleButton", true);

        return "show-requests";
    }

    @RequestMapping("toggle-it")
    public String updateMovieStatus(@RequestParam String movieName, @RequestParam String watchedIt, Model model){
        movieService.updateMovieStatus(movieName, watchedIt);
        return "redirect:/admin";
    }
}
