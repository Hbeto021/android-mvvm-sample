package com.home.hbeto021.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.home.hbeto021.R;
import com.home.hbeto021.domain.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class RvMovieAdapter extends RecyclerView.Adapter<RvMovieAdapter.RvMovieAdapterVH> {


    private List<Movie> movieList = new ArrayList<>();

    @NonNull
    @Override
    public RvMovieAdapterVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_item,
                viewGroup, false);
        return new RvMovieAdapterVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RvMovieAdapterVH viewHolder, int i) {

        viewHolder.tvTitle.setText(movieList.get(i).getTitle());
        viewHolder.tvGenre.setText(movieList.get(i).getGenre());

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void addMovieToList(List<Movie> movieList) {
        //Add list of movies in recycler view
        this.movieList.clear();
        this.movieList.addAll(movieList);
        notifyDataSetChanged();
    }

    public static class RvMovieAdapterVH extends RecyclerView.ViewHolder {

        private TextView tvTitle, tvGenre;

        public RvMovieAdapterVH(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvGenre = itemView.findViewById(R.id.tv_genre);
        }
    }

}
