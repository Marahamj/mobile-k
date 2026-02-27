package com.example.finalproject;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class DetailsActivity extends AppCompatActivity {

    ImageView image;
    TextView title, rating, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        image = findViewById(R.id.imgDetails);
        title = findViewById(R.id.txtTitleDetails);
        rating = findViewById(R.id.txtRatingDetails);
        description = findViewById(R.id.txtDescriptionDetails);

        String movieTitle = getIntent().getStringExtra("title");
        String movieRating = getIntent().getStringExtra("rating");
        String movieDescription = getIntent().getStringExtra("description");
        int movieImage = getIntent().getIntExtra("image", 0);

        title.setText(movieTitle);
        rating.setText("Rating: " + movieRating);
        description.setText(movieDescription);
        image.setImageResource(movieImage);
    }
}