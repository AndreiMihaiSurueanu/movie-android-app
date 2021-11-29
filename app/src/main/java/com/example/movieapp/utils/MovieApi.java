package com.example.movieapp.utils;

import com.example.movieapp.models.MovieModel;
import com.example.movieapp.response.MovieSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {

    // Search for movies
    // https://api.themoviedb.org/3/search/movie?api_key={api_key}&query=Jack+Reacher
    @GET("search/movie")
    Call<MovieSearchResponse> searchMovie(
            @Query("api_key") String key,
            @Query("query") String query,
            @Query("page") int page
    );

    // Making search with ID
    // https://api.themoviedb.org/3/movie/550?api_key=52a18783ed514602a5facb15a0177e61
    // Remember that movie_id= 550 is for Fight Club movie
    // Let's Test Jack Reacher id
    @GET("movie/{movie_id}")
    Call<MovieModel> getMovie(
            @Path("movie_id") int movie_id,
            @Query("api_key") String api_key
    );

}
