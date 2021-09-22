package com.example.OlympicsDemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/parent")
public class LoginController {

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {


        // return "plain-login";


        return "fancy-login";

    }

    // add request mapping for /access-denied

    @GetMapping("/access-denied")
    public String showAccessDenied() {

        return "access-denied";

    }

}
