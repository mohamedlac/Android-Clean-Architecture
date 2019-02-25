package com.example.yts_clean_architecture.Data.Repository.DataSource;

import com.example.yts_clean_architecture.Data.Api.Model.MovieResponse;
import com.example.yts_clean_architecture.Domain.Model.Api.Responses.MoviesResponse;

import io.reactivex.Observable;


public interface DataSource {

    Observable<MoviesResponse> latestMovieList(int limit);

    Observable<MoviesResponse> popularMovieList();


}
