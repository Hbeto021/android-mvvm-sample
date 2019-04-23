package com.home.hbeto021.view.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.home.hbeto021.R;
import com.home.hbeto021.domain.model.Movie;
import com.home.hbeto021.view.adapter.RvMovieAdapter;
import com.home.hbeto021.viewmodel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;

    private RvMovieAdapter adapterMovies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        initRecyclerView();
        initViews();
        observers();

    }


    private void initRecyclerView() {
        adapterMovies = new RvMovieAdapter();
        RecyclerView rvMovies = findViewById(R.id.rv_movies);
        rvMovies.setLayoutManager(new LinearLayoutManager(this));
        rvMovies.setAdapter(adapterMovies);
    }

    private void initViews() {
        FloatingActionButton fabCallFormDialog = findViewById(R.id.fab_call_form);
        fabCallFormDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCustomDialog();
            }
        });
    }

    private void observers() {
        viewModel.getAllMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(@Nullable List<Movie> movies) {
                adapterMovies.addMovieToList(movies);
            }
        });

        viewModel.getMessageToUser().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //only setValue and postValue calls the observers of MutableLiveData
                Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void showCustomDialog() {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.form_custom_dialog, null);
        dialogBuilder.setView(view);
        final AlertDialog dialog = dialogBuilder.create();
        final EditText edtTitle = view.findViewById(R.id.edt_title);
        final EditText edtGenre = view.findViewById(R.id.edt_genre);
        Button btnAdd = view.findViewById(R.id.btn_add);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.insertMovie(edtTitle.getEditableText().toString(),
                        edtGenre.getEditableText().toString());

                dialog.cancel();
            }
        });

        dialog.show();

    }

}
