package com.web.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignupController {
    @GetMapping(value= "/signup")
    public String signup() {
        return "signup";
    }
}
