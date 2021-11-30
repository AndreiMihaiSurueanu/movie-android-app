package com.example.movieapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapp.R;
import com.example.movieapp.models.MovieModel;

import java.util.List;

public class MovieRecyclerView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MovieModel> mMovies;
    private OnMovieListener onMovieListener;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
        return new MovieViewHolder(view, onMovieListener);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {

        ((MovieViewHolder)holder).title.setText(mMovies.get(i).getTitle());
        ((MovieViewHolder)holder).release_date.setText(mMovies.get(i).getRelease_date());
        ((MovieViewHolder)holder).duration.setText(mMovies.get(i).getRuntime());

        // We need to get the runtime & the category
        // We need to change the api response

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
