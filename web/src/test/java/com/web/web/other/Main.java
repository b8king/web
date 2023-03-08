package com.web.web.other;

import com.web.web.domain.SearchMusic;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //ParseTest parse = new ParseTest();
        //CheckUrl checkUrl = new CheckUrl();
        //Parse1 parse1 = new Parse1();
        //parse1.search();
        //checkUrl.validator();
        //System.out.println(CheckUrl.valid_URL);
        SearchMusic a = new SearchMusic();
        a.search("join");
    }
}
