package com.web.web.other;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.web.web.domain.Carcas;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class CheckUrl {
    private Document document;
    public static String links, artist, track_name, url, getUrl, photo_link;
    String server = "https://ru.muzikavsem.org";
    public static String Name;
    public static String Artist;
    public static String MASSIVE_URL;

    public static ArrayList<Carcas> newTrackList = new ArrayList();
    public void tracksNew() throws IOException {
        document = Jsoup.connect
                ("https://ru.muzikavsem.org/tracks-new").get();
        int num = document.getElementsByClass("top-tracks__download-btn clr-btn").size();
       newTrackList.clear();

        for (int i = 0; i < num; i++) {
            Element path = document.getElementsByClass("top-tracks__download-btn clr-btn").get(i);
            Element name = document.getElementsByClass("top-tracks__track").get(i);
            Element title = document.getElementsByClass("top-tracks__artist").get(i);
            Element photo = document.getElementsByClass("top-tracks__img").get(i);
            String img = photo.attr("style");
            String newStr = img.replaceAll("background-image: url", (""))
                    .replaceAll("\\(", "")
                    .replaceAll("\\)", "")
                    .replaceAll("'", "")
                    .replaceAll(";", "");

            String cut = "https://ru.muzikavsem.org" + newStr; // 34 (35,36)

            links = path.attr("href");
            artist = name.text();
            track_name = title.text();
            photo_link = cut;
            url = links;

            MASSIVE_URL = server + url;
            Artist = artist;
            Name = track_name;

            Carcas carcas = new Carcas(i,MASSIVE_URL, Artist, Name, photo_link);
            newTrackList.add(carcas);
            System.out.println(newTrackList.toString());
        }
    }
}
