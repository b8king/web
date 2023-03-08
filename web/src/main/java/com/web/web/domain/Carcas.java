package com.web.web.domain;

import java.util.ArrayList;

public class Carcas {
    private String toLink;
    private String artist;
    private String trackName;
    private String photo;

    public Carcas(String toLink, String artist, String trackName,String photo) {
        this.toLink = toLink;
        this.artist = artist;
        this.trackName = trackName;
        this.photo = photo;
    }

    public Carcas(ArrayList<String> list, ArrayList<String> listArtist, ArrayList<String> listNameTrack,ArrayList<String> photo) {

    }

    public Carcas() {

    }


    public String getToLink() {
        return toLink;
    }

    public void setToLink(String toLink) {
        this.toLink = toLink;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }







    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Carcas{" +
                "toLink='" + toLink + '\'' +
                ", artist='" + artist + '\'' +
                ", trackName='" + trackName + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
