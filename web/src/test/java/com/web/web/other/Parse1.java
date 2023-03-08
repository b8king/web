package com.web.web.other;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Parse1 {
    private Document document;
    public String links,artist,track_name,url,getUrl;
    String server = "https://cdn17.deliciouspeaches.com/";
    public void search() throws IOException {
        document = Jsoup.connect
                ("https://ru.hitmotop.com/search?q=" + "phonk").get();
        int num = document.getElementsByClass("track__info-l").size();
        for (int i=0;i<num;i++) {
            Element path = document.getElementsByClass("track__download-btn").get(i);
            Element name = document.getElementsByClass("track__title").get(i);
            Element  title = document.getElementsByClass("track__desc").get(i);
            links = path.attr("href");
            artist = name.text();
            track_name = title.text();
            url = links.replace("https://ru.hitmotop.com/","");
            getUrl = server+url;


            System.out.println(getUrl+"  "+artist+"  "+track_name);

        }
    }
}
