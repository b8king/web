package com.web.web.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String input,search,artist,name,link;

    public TestEntity(String artist, String name, String link) {
        this.artist = artist;
        this.name = name;
        this.link = link;
    }

    public TestEntity(String search, String link) {
        this.search = search;
        this.link = link;

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public TestEntity() {
    }

    public TestEntity(String search) {
        this.search = search;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink(String getUrl) {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
