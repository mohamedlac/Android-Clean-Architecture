package com.example.yts_clean_architecture.Domain.Model.Api.Subs;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class MovieStruct implements Serializable {

    @SerializedName("id")
    private final int id;

    @SerializedName("title")
    private final String title;

    @SerializedName("year")
    private  final int year;

    @SerializedName("rating")
    private final float rating;

    @SerializedName("genres")
    private ArrayList<String> genres;

    @SerializedName("summary")
    private String summary;

    @SerializedName("description_full")
    private String description_full;

    @SerializedName("synopsis")
    private String synopsis;

    @SerializedName("language")
    private String language;

    @SerializedName("medium_cover_image")
    private String image;


    public MovieStruct(int id, String title, int year, float rating, ArrayList<String> genres,
                       String summary, String description_full, String synopsis, String language, String image) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.genres = genres;
        this.summary = summary;
        this.description_full = description_full;
        this.synopsis = synopsis;
        this.language = language;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public float getRating() {
        return rating;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription_full() {
        return description_full;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getLanguage() {
        return language;
    }

    public String getImage() {
        return image;
    }
}
