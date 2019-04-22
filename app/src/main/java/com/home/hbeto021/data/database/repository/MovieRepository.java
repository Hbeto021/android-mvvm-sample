package com.home.hbeto021.data.database.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.home.hbeto021.data.database.AppDataBase;
import com.home.hbeto021.data.database.dao.MovieDao;
import com.home.hbeto021.domain.model.Movie;

import java.util.List;


public class MovieRepository implements MovieDao {

    private MovieDao dao;

    public MovieRepository(Application application) {
        dao = AppDataBase.getDataBase(application.getBaseContext()).movieDao();
    }

    @Override
    public void insertMovie(Movie movie) {
        new insertMovie(dao).execute(movie);
    }

    @Override
    public void updateMovie(Movie movie) {

    }

    @Override
    public void deleteMovie(Movie movie) {

    }

    @Override
    public void deleteAllMovies() {

    }

    @Override
    public LiveData<List<Movie>> selectAllMovies() {

        return dao.selectAllMovies();
    }

    //Room does not permit long operations in UI Thread (main thread)
    private static class insertMovie extends AsyncTask<Movie, Void, Void> {
        private MovieDao dao;

        private insertMovie(MovieDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Movie... movies) {
            dao.insertMovie(movies[0]);
            return null;
        }
    }

}
