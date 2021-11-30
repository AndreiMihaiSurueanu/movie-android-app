package com.example.movieapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.movieapp.models.MovieModel;

import java.util.List;

public class MovieListViewModel extends ViewModel {

    // this class is used for VIEWMODEL


    // Constructor
    public MovieListViewModel() {

    }

    public LiveData<List<MovieModel>> getMovies() {
        return mMovies;
    }

}
