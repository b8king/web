package com.web.web.domain;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;




public class SearchMusic {
    private Document document;
    private Element element;
    public String getName;
    public String getImage;
    public String getArtist;
    public static String FILE_URL;
    public static String IMG_URL;
    public static String IMG_NAME = "src/main/resources/b8king/explot/music/";
    public static String FILE_NAME = "src/main/resources/b8king/explot/music/228.mp3";

    public void getSearch(String TRACK_NAME, int index) {

        try {
            document = Jsoup.connect
                    ("https://ru.hitmotop.com/search?q=" + TRACK_NAME).get();
            Elements anchors = document.getElementsByClass("track__download-btn");


            String links = anchors.attr("href");
            FILE_URL = links;

            Elements anchors1 = document.getElementsByClass("track__title");
            String a = "();";

            getName = anchors1.eachText().get(index);

            Elements anchors2 = document.getElementsByClass("track__desc");
            getArtist = anchors2.eachText().get(index);
            Elements anchors3 = document.getElementsByClass("track__img");
            String img = anchors3.attr("style");
            String newStr = img.replaceAll("background-image: url", "");
            String imgCut = newStr.replaceAll("\\p{P}", "/");

            String cut = "https://ru.hitmotop.com" + imgCut.substring(2, 25) + ".jpg";
            IMG_URL = cut;
            System.out.println(cut);
            System.out.println(FILE_URL + " --> " + " [" + getArtist + "] " + getName);


            try (BufferedInputStream in = new BufferedInputStream(new URL(FILE_URL).openStream());
                 FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME)) {
                byte dataBuffer[] = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                }
            } catch (IOException e) {
                // handle exception
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("200OK");

        }


    }
}
