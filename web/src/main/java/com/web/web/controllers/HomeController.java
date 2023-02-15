package com.web.web.controllers;

import com.web.web.domain.SearchMusic;
import com.web.web.domain.TestEntity;

import com.web.web.repo.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


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
        model.addAttribute("name", searchMusic.getName);
        model.addAttribute("artist",searchMusic.getArtist);
        model.addAttribute("img", SearchMusic.IMG_URL);
        model.addAttribute("link", SearchMusic.PLAY_URL_2);
        //System.out.println(SearchMusic.valid_URL);
        return "result";
    }

    @PostMapping(value = "/")
    public String search(@RequestPart String search, Model model) throws IOException {
        TestEntity post = new TestEntity(search);
        searchMusic.getSearch(search, 0);
        repository.save(post);
        return "redirect:/result";
    }

}


