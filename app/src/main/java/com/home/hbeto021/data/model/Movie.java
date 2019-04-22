package com.home.hbeto021.data.model;

import java.io.Serializable;

public class Movie implements Serializable {

    private int id;
    private String title;
    private String genre;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        if (title == null) {
            title = "";
        }
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        if (genre == null) {
            genre = "";
        }
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Title: " + getTitle() + "Genre: " + getGenre();
    }
}
