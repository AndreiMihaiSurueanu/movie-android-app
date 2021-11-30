package com.example.movieapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.movieapp.models.MovieModel;

import java.util.List;

public class MovieListViewModel {

    // this class is used for VIEWMODEL

    // Live Data
    private MutableLiveData<List<MovieModel>> mMovies = new MutableLiveData<>();

    // Constructor
    public MovieListViewModel() {

    }

    public LiveData<List<MovieModel>> getMovies() {
        return mMovies;
    }

}
