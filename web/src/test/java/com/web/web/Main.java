package com.web.web;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ParseTest parse = new ParseTest();
        CheckUrl checkUrl = new CheckUrl();
        parse.getSearch("",0);
        checkUrl.validator();
        System.out.println(CheckUrl.valid_URL);

    }
}
