package com.example.finalproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context context;
    private ArrayList<Movie> movieList;

    public MovieAdapter(Context context, ArrayList<Movie> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);

        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {

        Movie movie = movieList.get(position);

        holder.title.setText(movie.getTitle());
        holder.rating.setText("Rating: " + movie.getRating());
        holder.image.setImageResource(movie.getImage());

        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(context, DetailsActivity.class);

            intent.putExtra("title", movie.getTitle());
            intent.putExtra("rating", movie.getRating());
            intent.putExtra("description", movie.getDescription());
            intent.putExtra("image", movie.getImage());

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, rating;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imgMovie);
            title = itemView.findViewById(R.id.txtTitle);
            rating = itemView.findViewById(R.id.txtRating);
        }
    }
}