package com.web.web;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CheckUrl {
    public static String valid_URL;


    public void СomLink(String a, String b) {

        if (a == b) {
            System.out.println("+");
        } else {
            System.out.println("-");
        }
    }


    public void validator() throws IOException {
        ParseTest parse = new ParseTest();
        Exception e = new Exception();
        URL url = new URL(parse.PLAY_URL);
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        String statusCode = String.valueOf(http.getResponseCode());
        System.out.println("server 1:" + statusCode);
        if (statusCode != e.getMessage()) {
            URL url2 = new URL(parse.PLAY_URL_2);
            HttpURLConnection http2 = (HttpURLConnection) url2.openConnection();
            String statusCode2 = String.valueOf(http2.getResponseCode());
            System.out.println("server 2:" + statusCode2);
            valid_URL = parse.PLAY_URL_2;
            if (statusCode2 != e.getMessage()) {
                URL url3 = new URL(parse.PLAY_URL_3);
                HttpURLConnection http3 = (HttpURLConnection) url3.openConnection();
                String statusCode3 = String.valueOf(http3.getResponseCode());
                System.out.println("server 3:" + statusCode3);
                valid_URL = parse.PLAY_URL_3;
            }
        }
    }
}
