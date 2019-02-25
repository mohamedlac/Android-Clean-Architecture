package com.example.yts_clean_architecture.Data.Api;
import com.example.yts_clean_architecture.Domain.Model.Api.Responses.MoviesResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("list_movies.json?sort_by=date_added")
    Observable<MoviesResponse> getLatestMovieList(@Query("limit")int limit);

    @GET("movie_detail.json")
    Observable<?> getMovieDetail(@Query("movie_id") int movie_id);

    @GET("list_movies.json?sort_by=download_count&limit=4")
    Observable<MoviesResponse> getPopularDownloads();
}
