package com.home.hbeto021.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.home.hbeto021.domain.model.Movie;
import com.home.hbeto021.domain.usecase.UseCaseMovie;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private UseCaseMovie ucMovie;
    private MutableLiveData<String> msgToUser = new MutableLiveData<>();

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        ucMovie = new UseCaseMovie(application);

    }

    public void insertMovie(String titleMovie, String genreMovie) {
        if (ucMovie.insert(titleMovie, genreMovie)) {
            msgToUser.setValue("The movie was added.");
        } else {
            msgToUser.setValue("Fail, there are some empty fields.");
        }
    }

    public MutableLiveData<String> getMessageToUser() {
        return msgToUser;
    }

    public LiveData<List<Movie>> getAllMovies() {
        return ucMovie.getAllMovies();
    }

}
