package com.example.crud_api;

import android.content.Context;

public class TopRatedMovies {
    MoviesApi movieApi;

    public TopRatedMovies(Context context) {
        movieApi = RetrofitBuilder.builder(context).create(MoviesApi.class);
    }

    public MoviesApi getInstance() {
        return movieApi;
    }
}
