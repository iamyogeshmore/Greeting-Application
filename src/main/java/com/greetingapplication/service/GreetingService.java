package com.greetingapplication.service;

import com.greetingapplication.model.Greeting;
import com.greetingapplication.repository.GreetingAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    @Autowired
    private GreetingAppRepository repository;

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

    //--------------------------------- Save in repository ---------------------------------
    public Greeting saveGreetings(Greeting greeting) {
        return repository.save(greeting);
    }

    //--------------------------------- Find greeting by Id ---------------------------------
    public Greeting findGreetingById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
