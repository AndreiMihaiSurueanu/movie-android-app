package com.example.movieapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.movieapp.models.MovieModel;
import com.example.movieapp.viewmodels.MovieListViewModel;

import java.util.List;

public class MovieListActivity extends AppCompatActivity {

    // Before we run our app, we need to add the Network Security config

    Button btn;

    // ViewModel
    private MovieListViewModel movieListViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);

        movieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);

        // Calling the observers
        ObserveAnyChange();

        // Testing the Method
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Displaying only the results of page 1
                searchMovieApi("fast", 2);
            }
        });

    }

    // Observing any data change
    private void ObserveAnyChange(){
        movieListViewModel.getMovies().observe(this, new Observer<List<MovieModel>>(){
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                // Observing for any data change
                if (movieModels != null) {
                    for (MovieModel movieModel: movieModels){
                        // Get the data in log
                        Log.v("Tagy", "onChanged: " + movieModel.getTitle());
                    }
                }
            }
        });
    }

    // 4- Calling method in Main Activity
    private void searchMovieApi(String query, int pageNumber){
        movieListViewModel.searchMovieApi(query, pageNumber);
    }

//    private void GetRetrofitResponse() {
//        MovieApi movieApi = Servicey.getMovieApi();
//
//        Call<MovieSearchResponse> responseCall = movieApi
//                .searchMovie(
//                        Credentials.API_KEY,
//                        "Jack Reacher",
//                        1
//                );
//
//        responseCall.enqueue(new Callback<MovieSearchResponse>() {
//            @Override
//            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {
//                if(response.code() == 200){
//                    Log.v("Tag", "the response" + response.body().toString());
//
//                    List<MovieModel> movies = new ArrayList<>(response.body().getMovies());
//
//                    for (MovieModel movie : movies) {
//                        Log.v("Tag", "The release date" + movie.getRelease_date());
//                    }
//                } else {
//                    try {
//                        Log.v("Tag", "Error" + response.errorBody().string());
//                    } catch (IOException e){
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MovieSearchResponse> call, Throwable t) {
//
//            }
//        });
//    }

//    private void GetRetrofitResponseAccordingToID() {
//        MovieApi movieApi = Servicey.getMovieApi();
//
//        Call<MovieModel> responseCall = movieApi
//                .getMovie(
//                        343611,
//                        Credentials.API_KEY
//                );
//
//        responseCall.enqueue(new Callback<MovieModel>() {
//            @Override
//            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
//                if(response.code() == 200){
//
//                    MovieModel movie = response.body();
//
//                    Log.v("Tag: ", "The Response " + movie.getTitle());
//
//                } else {
//                    try {
//                        Log.v("Tag", "Error" + response.errorBody().string());
//                    } catch (IOException e){
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MovieModel> call, Throwable t) {
//
//            }
//        });
//    }

}