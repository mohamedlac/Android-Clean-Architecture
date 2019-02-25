package com.example.yts_clean_architecture.Data.Repository;


import com.example.yts_clean_architecture.Data.Repository.DataSource.MovieDataSource;
import com.example.yts_clean_architecture.Domain.Model.Api.Responses.MoviesResponse;


import javax.inject.Inject;

import io.reactivex.Observable;

public class MoviesRepository implements Repository {

    private MovieDataSource dataSource;


    @Inject
    public MoviesRepository(MovieDataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    @Override
    public Observable<MoviesResponse> getLatestMovies(int limit) {
        return dataSource.latestMovieList(limit );
    }

    @Override
    public Observable<MoviesResponse> getPopularMovies() {
        return dataSource.popularMovieList();
    }



}
