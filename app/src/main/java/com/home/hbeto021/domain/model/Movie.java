package com.home.hbeto021.domain.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

/**
 * Class that represents a table on data base
 */
@Entity(tableName = "tb_movie")
public class Movie implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String genre;

    public Movie() {
    }

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
