package com.example.yts_clean_architecture.Domain.UseCases;

import com.example.yts_clean_architecture.Data.Repository.MoviesRepository;
import com.example.yts_clean_architecture.Data.Repository.Repository;
import com.example.yts_clean_architecture.Domain.Model.Api.Responses.MoviesResponse;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

public class GetPopularMovies extends UseCase<MoviesResponse> {

    Repository repository;

    @Inject
    public GetPopularMovies(@Named("executor_thread") Scheduler executorThread,
                     @Named("ui_thread") Scheduler uiThread, MoviesRepository repository)
    {
        super(executorThread,uiThread);
        this.repository = repository;
    }

    @Override
    protected Observable<MoviesResponse> createObservableUseCase() {
        return repository.getPopularMovies();
    }
}
