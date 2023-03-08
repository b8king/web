package com.web.web.domain;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SearchMusic {
    private Document document;
    public static String links,artist,track_name,url,getUrl,photo_link;
    String server = "https://ru.muzikavsem.org";


    private Element element;
    public static String Name; //


    public static String Artist; //

    public static String MASSIVE_URL;

    public static ArrayList<Carcas> list = new ArrayList();




    public void search(String get_search) throws IOException {


        document = Jsoup.connect
                ("https://ru.muzikavsem.org/search/" + get_search).get();
        int num = document.getElementsByClass("top-tracks__download-btn clr-btn").size();
        list.clear();


        for (int i = 0; i < num; i++) {
            Element path = document.getElementsByClass("top-tracks__download-btn clr-btn").get(i);
            Element name = document.getElementsByClass("top-tracks__track").get(i);
            Element title = document.getElementsByClass("top-tracks__artist").get(i);
            Element photo = document.getElementsByClass("top-tracks__img").get(i);
            links = path.attr("href");
            artist = name.text();
            track_name = title.text();
            photo_link = photo.text();
            url = links;

            MASSIVE_URL = server + url;


            Artist = artist;
            Name = track_name;

            Carcas carcas = new Carcas(MASSIVE_URL,Artist,Name,photo_link);
            list.add(carcas);
            System.out.println(photo_link);


            }

            System.out.println("--> "+list.toString());
        }

}
