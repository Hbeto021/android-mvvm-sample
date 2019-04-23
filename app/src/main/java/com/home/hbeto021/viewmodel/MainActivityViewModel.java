package com.home.hbeto021.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.media.midi.MidiOutputPort;
import android.support.annotation.NonNull;

import com.home.hbeto021.domain.model.Movie;
import com.home.hbeto021.domain.usecase.UseCaseMovie;

import java.nio.channels.MulticastChannel;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private UseCaseMovie ucMovie;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        ucMovie = new UseCaseMovie(application);

    }

    public boolean insertMovie(Movie movie) {
        return ucMovie.insert(movie);
    }

    public LiveData<List<Movie>> getAllMovies() {
        return ucMovie.getAllMovies();
    }
}
