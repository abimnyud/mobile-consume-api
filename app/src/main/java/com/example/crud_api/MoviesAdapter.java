package com.example.crud_api;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    List<Movie> result;
    Activity activity;

    public MoviesAdapter(List<Movie> result, Activity activity) {
        this.result = result;
        this.activity = activity;
    }

    public MoviesAdapter(TopRatedMovies topRatedMovies) {}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movies, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(result.get(position));
    }

    @Override
    public int getItemCount() {
        return this.result != null ? this.result.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_id, tv_title, tv_release_date, tv_language, tv_rating, tv_overview;
        ImageView poster;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_id = itemView.findViewById(R.id.tv_id);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_language = itemView.findViewById(R.id.tv_language);
            tv_release_date = itemView.findViewById(R.id.tv_release_date);
            tv_rating = itemView.findViewById(R.id.tv_rating);
            tv_overview = itemView.findViewById(R.id.tv_overview);
            poster = itemView.findViewById(R.id.poster);
        }

        public void bind(Movie movieItem) {
//            Log.v("RESPONSE", moviesItem.body().getResult().get(0).original_language);

            tv_id.setText(movieItem.id.toString());
            tv_title.setText(movieItem.original_title + "");
            tv_language.setText(movieItem.original_language + "");
            tv_release_date.setText(movieItem.release_date + "");
            tv_rating.setText(String.format(movieItem.vote_average.toString()) + "");
            tv_overview.setText(movieItem.overview + "");

            Glide.with(activity).load("https://image.tmdb.org/t/p/original" + movieItem.poster_path).into(poster);
        }
    }

}
