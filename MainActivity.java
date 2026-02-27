package com.example.finalproject;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MovieAdapter adapter;
    ArrayList<Movie> movieList;
    Button btnToggle;

    boolean isLinear = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        btnToggle = findViewById(R.id.btnToggle);

        movieList = new ArrayList<>();

        // بيانات تجريبية
        movieList.add(new Movie("Inception", "8.8", "Sci-Fi Movie", R.drawable.ic_launcher_background));
        movieList.add(new Movie("Titanic", "7.9", "Romance Movie", R.drawable.ic_launcher_background));
        movieList.add(new Movie("Avatar", "7.8", "Action Movie", R.drawable.ic_launcher_background));

        adapter = new MovieAdapter(this, movieList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnToggle.setOnClickListener(v -> {
            if (isLinear) {
                recyclerView.setLayoutManager(new androidx.recyclerview.widget.GridLayoutManager(this, 2));
            } else {
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
            }
            isLinear = !isLinear;
        });
    }
}
