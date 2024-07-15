package com.jatin.checker_website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String to, String subject, String movieName){
        String emailText = buildMovieMail(movieName);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(emailText);
        mailSender.send(message);
    }

    public String buildMovieMail(String movieName){
        return "Hi Jatin, Have you seen " + movieName.toUpperCase() + " ?";
    }
}
