package com.example.yts_clean_architecture.Home.ViewModel;

public class MovieViewModel {

    private final String title;
    private final String image;
    private final int year;
    private final float rating;


    public MovieViewModel(String title, String image, int year, float rating) {
        this.title = title;
        this.image = image;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public int getYear() {
        return year;
    }

    public float getRating() {
        return rating;
    }
}
