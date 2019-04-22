package com.home.hbeto021.data.database.dao;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.home.hbeto021.domain.model.Movie;

import java.util.List;

@Dao
public interface MovieDao {

    @Insert
    void insertMovie(Movie movie);

    @Update
    void updateMovie(Movie movie);

    @Delete
    void deleteMovie(Movie movie);

    @Query("DELETE FROM tb_movie")
    void deleteAllMovies();

    @Query("SELECT * FROM tb_movie")
    LiveData<List<Movie>> selectAllMovies();
}
