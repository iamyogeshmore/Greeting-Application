package com.greetingapplication.controller;

import com.greetingapplication.model.Greeting;
import com.greetingapplication.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    @Autowired
    GreetingService greetingService;
    public static final String template = " Welcome to the greeting app.";
    public final AtomicLong counter = new AtomicLong();

    //--------------------------------- Get String Message ---------------------------------
    @RequestMapping("/welcomeGreeting")
    public String displayMessage() {
        return greetingService.greetingMessage();
    }

    //--------------------------------- Get count and message ---------------------------------
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "User") String name) {
        return new Greeting((int) counter.incrementAndGet(), String.format(template, name));
    }

    //--------------------------------- Get Greetings By Name ---------------------------------
    @GetMapping("/greetingsByName")
    public String greetingWithUserName(@RequestParam(value = "firstName", defaultValue = "") String firstName,
                                       @RequestParam(value = "lastName", defaultValue = "") String lastName) {
        return greetingService.greetingWithUserName(firstName, lastName);
    }

    //--------------------------------- Save in repository ---------------------------------
    @PostMapping("/addGreeting")
    public Greeting addGreeting(@RequestBody Greeting greeting) {
        return greetingService.saveGreetings(greeting);
    }

    //--------------------------------- Find greeting by Id ---------------------------------
    @GetMapping("/greetingById/{id}")
    public Greeting getGreetingById(@PathVariable Integer id) {
        return greetingService.findGreetingById(id);
    }

    //--------------------------------- List of greeting ---------------------------------
    @GetMapping("/allGreetings")
    public List<Greeting> findAllGreetings() {
        return greetingService.findGreetings();
    }

    //--------------------------------- Edit greeting ---------------------------------
    @PutMapping("/editGreeting/{id}")
    public Greeting editGreeting(@RequestBody Greeting greeting, @PathVariable Integer id) {
        return greetingService.editGreeting(greeting, id);
    }
}