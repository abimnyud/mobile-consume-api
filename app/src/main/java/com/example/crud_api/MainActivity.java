package com.example.crud_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TopRatedMovies topRatedMovies;
    MoviesAdapter adapter;
    RecyclerView rv_movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_movies = findViewById(R.id.rv_movies);
        topRatedMovies = new TopRatedMovies(this);

        rv_movies.setHasFixedSize(true);
        rv_movies.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MoviesAdapter(topRatedMovies);
        rv_movies.setAdapter(adapter);

        getTopRatedMovies();
    }

    public void getTopRatedMovies() {
        topRatedMovies.getInstance().getTopRatedMovies().enqueue(new Callback<MoviesResponse<Movie>>() {
            @Override
            public void onResponse(Call<MoviesResponse<Movie>> call, Response<MoviesResponse<Movie>> response) {
                MoviesResponse<Movie> res = response.body();

                if (res.getResult() != null && res.getResult().size() > 0) {
                    adapter = new MoviesAdapter(res.getResult(), MainActivity.this);
                    rv_movies.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<MoviesResponse<Movie>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}