package com.jatin.checker_website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String adminMail;

    @Value("Movie Mail!!")
    private String subject;

    public void sendEmail(String movieName){
        String emailText = buildMovieMail(movieName);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(adminMail);
        message.setSubject(subject);
        message.setText(emailText);
        mailSender.send(message);
    }

    public String buildMovieMail(String movieName){
        return "Hi Jatin, Have you seen " + movieName.toUpperCase() + " ?";
    }
}
