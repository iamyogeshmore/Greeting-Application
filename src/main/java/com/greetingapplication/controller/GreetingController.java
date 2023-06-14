package com.greetingapplication.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
    public static final String template = " Welcome to the greeting app.";

    //--------------------------------- Get String with PathVariable ---------------------------------
    @RequestMapping("/query1/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello " + name + template;
    }

    //--------------------------------- Get String with RequestParam ---------------------------------
    @RequestMapping(value = {"/query2"}, method = RequestMethod.GET)
    public String sayHelloParam(@RequestParam(value = "name") String name) {
        return "Hello " + name + template;
    }
}
