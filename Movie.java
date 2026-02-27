package com.example.finalproject;

public class Movie {

        private String title;
        private String rating;
        private String description;
        private int image;

        public Movie(String title, String rating, String description, int image) {
            this.title = title;
            this.rating = rating;
            this.description = description;
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public String getRating() {
            return rating;
        }

        public String getDescription() {
            return description;
        }

        public int getImage() {
            return image;
        }
}
