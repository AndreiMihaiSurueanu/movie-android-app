package com.example.movieapp.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.movieapp.models.MovieModel;

import java.util.List;

public class MovieRepository {
    // This class is acting as repositories

    // Live Data
    private MutableLiveData<List<MovieModel>> mMovies = new MutableLiveData<>();

}
