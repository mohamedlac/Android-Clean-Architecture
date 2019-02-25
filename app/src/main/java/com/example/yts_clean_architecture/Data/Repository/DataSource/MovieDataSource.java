package com.example.yts_clean_architecture.Data.Repository.DataSource;

import com.example.yts_clean_architecture.Data.Api.ApiService;
import com.example.yts_clean_architecture.Domain.Model.Api.Responses.MoviesResponse;

import javax.inject.Inject;

import io.reactivex.Observable;

public class MovieDataSource implements DataSource {

    private ApiService apiService;


    @Inject
    public MovieDataSource(ApiService apiService)
    {
        this.apiService = apiService;
    }



    @Override
    public Observable<MoviesResponse> latestMovieList(int limit) {
        return apiService.getLatestMovieList(limit);
    }

    @Override
    public Observable<MoviesResponse> popularMovieList() {
        return apiService.getPopularDownloads();
    }
}
