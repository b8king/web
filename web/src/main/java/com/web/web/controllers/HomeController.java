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
import java.util.HashSet;
import java.util.Set;


@Controller
public class HomeController  {


    SearchMusic searchMusic = new SearchMusic();
    public static ArrayList<Carcas>list = new ArrayList<>();





    @Autowired
    private Repository repository;


    @GetMapping(value = "/")
    public String index(Model model) throws IOException {

        searchMusic.tracksNew();
        model.addAttribute("trackList",SearchMusic.newTrackList);
        return "index";
    }


    @GetMapping(value = "/result")
    public String result(Model model) throws IOException {

        searchMusic.tracksNew();
        Iterable<TestEntity> testEntities = repository.findAll();
        model.addAttribute("continents",SearchMusic.list);
        return "result";
    }



    @PostMapping(value = "/")
    public String search(@RequestPart String search,String name,String artist,String link, Model model) throws IOException {
        link = SearchMusic.getUrl;
        TestEntity post = new TestEntity(search,link);;
        searchMusic.search(search);;
        repository.save(post);
        return "redirect:/result";
    }

    @GetMapping(value = "/content{id}")
    public String cont(@PathVariable(value = "id") int id,Model model) throws IOException {

        SearchMusic.favouritesList = SearchMusic.list.get(id);
        list.add(SearchMusic.favouritesList);
        model.addAttribute("content",list);
        return "content";
    }

    @GetMapping(value = "/home-content{id}")
    public String ho(@PathVariable(value = "id") int id,Model model) throws IOException {

        list.add(SearchMusic.newTrackList.get(id));
        model.addAttribute("content",list);
        System.out.println(SearchMusic.favouritesList.toString());
        return "home-content";
    }

    @GetMapping(value = "/delete={name}")
    public String del(@PathVariable(value = "name") String name, Model model) throws IOException {

        for (Carcas ar: list) {
            if (ar.getArtist().equals(name)) {
                list.remove(ar);
            }
        }
        return "delete=";
    }

}


