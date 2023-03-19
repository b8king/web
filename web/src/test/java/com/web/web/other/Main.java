package com.web.web.other;

import com.web.web.domain.SearchMusic;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        CheckUrl loop = new CheckUrl();
        loop.tracksNew();
    }
}
