package com.example.OlympicsDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome() {

        return "home";
    }

    // add request mapping for /leaders

    @GetMapping("/player")
    public String showLeaders() {

        return "player";
    }

    // add request mapping for /systems

    @GetMapping("/user")
    public String showSystems() {

        return "user";
    }

}

