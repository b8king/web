package com.web.web.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class FavouritesController {
    @GetMapping(value= "/favourites")
    public String favourites(Model model) {

        model.addAttribute("like",HomeController.list);
        return "favourites";
    }
}
