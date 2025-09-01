package com.leevilaune.association;

import java.util.ArrayList;
import java.util.List;

public class Book {

        private String author;
        private String title;
        private int publicationYear;
        private List<Double> ratings;
        private List<String> reviews;

        public Book(String author, String title, int publicationYear) {
                this.author = author;
                this.title = title;
                this.publicationYear = publicationYear;
                this.ratings = new ArrayList<>();
                this.reviews = new ArrayList<>();
        }

        public String getAuthor() {
                return author;
        }

        public void setAuthor(String author) {
                this.author = author;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public int getPublicationYear() {
                return publicationYear;
        }

        public void setPublicationYear(int publicationYear) {
                this.publicationYear = publicationYear;
        }

        public void setRating(double rating) {
                this.ratings.add(rating);
        }

        public void addReview(String review) {
                this.reviews.add(review);
        }

        public List<Double> getRatings() {
                return ratings;
        }

        public void setRatings(List<Double> ratings) {
                this.ratings = ratings;
        }

        public List<String> getReviews() {
                return reviews;
        }

        public void setReviews(List<String> reviews) {
                this.reviews = reviews;
        }

        public double averageRating() {
                double total = 0;
                for (double d : this.ratings) {
                        total += d;
                }
                return total / this.ratings.size();
        }

        public String toString() {
                return "Title: " + title + ", Author: " + author + ", Year: " + publicationYear;
        }

}
