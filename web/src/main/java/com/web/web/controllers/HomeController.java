package com.web.web.controllers;

import com.web.web.domain.Carcas;
import com.web.web.domain.SearchMusic;
import com.web.web.domain.TestEntity;

import com.web.web.repo.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;


@Controller
public class HomeController  {


    SearchMusic searchMusic = new SearchMusic();

    @Autowired
    private Repository repository;

    @GetMapping(value = "/")
    public String home(Model model) throws IOException {

        return "index";
    }

    @GetMapping(value = "/result")
    public String result(Model model) throws IOException {



        Iterable<TestEntity> testEntities = repository.findAll();

        model.addAttribute("continents",SearchMusic.list);

        return "result";
    }

    @PostMapping(value = "/")
    public String search(@RequestPart String search,String name,String artist,String link, Model model) throws IOException {

        link = SearchMusic.getUrl;
        TestEntity post = new TestEntity(search,link);
        searchMusic.search(search);
        repository.save(post);
        System.out.println(link);
        return "redirect:/result";
    }

}


