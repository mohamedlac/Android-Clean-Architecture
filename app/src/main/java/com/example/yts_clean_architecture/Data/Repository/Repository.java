package com.example.yts_clean_architecture.Data.Repository;

import com.example.yts_clean_architecture.Domain.Model.Api.Responses.MoviesResponse;

import io.reactivex.Observable;


public interface Repository {


     Observable<MoviesResponse> getLatestMovies(int limit);

     Observable<MoviesResponse> getPopularMovies();


}
