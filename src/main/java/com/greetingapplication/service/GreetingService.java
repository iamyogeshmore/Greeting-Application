package com.greetingapplication.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    //--------------------------------- Get String Message ---------------------------------
    public String greetingMessage() {
        return "Hello World!";
    }

    //--------------------------------- Get Greetings By Name ---------------------------------
    public String greetingWithUserName(String firstName, String lastName) {
        if (firstName.isEmpty() && lastName.isEmpty())
            return greetingMessage();
        else if (!(firstName.equals("")) && (lastName.equals(""))) {
            return "Welcome to the greeting app, " + firstName;
        } else if (!(lastName.equals("")) && (firstName.equals(""))) {
            return "Welcome to the greeting app, " + lastName;
        } else
            return "Welcome to the greeting app, " + firstName + " " + lastName + "!";
    }
}
