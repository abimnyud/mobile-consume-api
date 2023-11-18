package com.example.crud_api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesApi {
    @GET("/3/movie/top_rated?language=id-ID&page=1")
    Call<MoviesResponse<Movie>> getTopRatedMovies();
}
