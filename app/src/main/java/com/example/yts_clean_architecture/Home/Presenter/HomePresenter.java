package com.example.yts_clean_architecture.Home.Presenter;

import com.example.yts_clean_architecture.Data.Mapper.MovieEntityMapper;
import com.example.yts_clean_architecture.Domain.Model.Api.Responses.MoviesResponse;
import com.example.yts_clean_architecture.Domain.UseCases.GetMovies;
import com.example.yts_clean_architecture.Domain.UseCases.GetPopularMovies;
import com.example.yts_clean_architecture.Home.View.View;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

public class HomePresenter implements presenter {

    private GetMovies getMovies;
    private GetPopularMovies getPopularMovies;
    private View view;

    @Inject
    public HomePresenter(GetMovies getMovies,GetPopularMovies getPopularMovies)
    {
        this.getMovies = getMovies;
        this.getPopularMovies = getPopularMovies;
    }


    @Override
    public View getView() {
        return view;
    }

    @Override
    public void initView(View v) {
        this.view = v;
    }

    @Override
    public void initialize() {
        getMovies.execute(new DisposableObserver<MoviesResponse>() {
            @Override
            public void onNext(MoviesResponse moviesResponse) {
                if(moviesResponse.getStatus().toLowerCase().equals("ok"))
                {
                    if(!(moviesResponse.getData().getMovie_count() == 0))
                    {
                        MovieEntityMapper mapper = new MovieEntityMapper();
                        getView().showLatestMovies(mapper.mapTo(moviesResponse.getData().getMovies()));
                    }
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


        getPopularMovies.execute(new DisposableObserver<MoviesResponse>() {
            @Override
            public void onNext(MoviesResponse moviesResponse) {
                if(moviesResponse.getStatus().toLowerCase().equals("ok"))
                {
                    if(!(moviesResponse.getData().getMovie_count() == 0))
                    {
                        MovieEntityMapper mapper = new MovieEntityMapper();
                        getView().showPopularMovies(mapper.mapTo(moviesResponse.getData().getMovies()));
                    }
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void onDestroy() {
        getMovies.dispose();
        getPopularMovies.dispose();
    }
}
