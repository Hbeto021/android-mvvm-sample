package com.home.hbeto021.domain.usecase;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.home.hbeto021.data.database.repository.MovieRepository;
import com.home.hbeto021.domain.model.Movie;

import java.util.List;

/**
 * Class the contains the logic and conditions of data persistence
 * Remove any type of logic from viewmodel
 * Interacts with repository
 * Provides usable data from repository to viewmodel
 */
public class UseCaseMovie {

    private MovieRepository repository;

    public UseCaseMovie(Application application) {
        repository = new MovieRepository(application);
    }

    public boolean insert(String titleMovie, String genreMovie) {
        Movie movie = new Movie(titleMovie, genreMovie);
        if (movie.isMovieValid()) {
            repository.insertMovie(movie);
            return true;
        } else {
            return false;
        }

    }

    public LiveData<List<Movie>> getAllMovies() {
        return repository.selectAllMovies();
    }


}
