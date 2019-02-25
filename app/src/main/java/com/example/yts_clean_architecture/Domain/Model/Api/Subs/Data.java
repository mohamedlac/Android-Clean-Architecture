package com.example.yts_clean_architecture.Domain.Model.Api.Subs;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Data implements Serializable {

    @SerializedName("movie_count")
    private final int movie_count;

    @SerializedName("limit")
    private final int limit;

    @SerializedName("page_number")
    private final int page_number;

    @SerializedName("movies")
    private final ArrayList<MovieStruct> movies;


    public Data(int movie_count, int limit, int page_number, ArrayList<MovieStruct> movies) {
        this.movie_count = movie_count;
        this.limit = limit;
        this.page_number = page_number;
        this.movies = movies;
    }

    public int getMovie_count() {
        return movie_count;
    }

    public int getLimit() {
        return limit;
    }

    public int getPage_number() {
        return page_number;
    }

    public ArrayList<MovieStruct> getMovies() {
        return movies;
    }
}
