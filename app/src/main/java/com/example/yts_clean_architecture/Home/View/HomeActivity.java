package com.example.yts_clean_architecture.Home.View;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.yts_clean_architecture.Adapter.MoviesAdapter;
import com.example.yts_clean_architecture.Base.View.BaseActivity;
import com.example.yts_clean_architecture.Home.Presenter.HomePresenter;
import com.example.yts_clean_architecture.Home.ViewModel.MovieViewModel;
import com.example.yts_clean_architecture.R;
import com.example.yts_clean_architecture.YTSApplication;

import java.util.List;

import javax.inject.Inject;

public class HomeActivity extends BaseActivity implements View {

    @Inject
    HomePresenter presenter;
    
    private MoviesAdapter popularMovieAdapter;
    private MoviesAdapter latestMovieAdapter;
    private RecyclerView popularMovieList;
    private RecyclerView latestMovieList;
    

    @Override
    public void initView() {
        super.initView();
        initWidgets();
        initDagger();
        initPresenter();
        initializeAdapter();
        initPopularMoviesRecyclerView();
        initLatestMoviesRecyclerView();
        presenter.initialize();
    }

    private void initWidgets()
    {

        popularMovieList = findViewById(R.id.popular_movie_list);
        latestMovieList = findViewById(R.id.latest_movie_list);
    }

    private void initPopularMoviesRecyclerView()
    {
        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        popularMovieList.setLayoutManager(layoutManager);
        popularMovieList.setItemAnimator(new DefaultItemAnimator());
        popularMovieList.setAdapter(popularMovieAdapter);
    }

    private void initLatestMoviesRecyclerView()
    {
       // RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this,2);
        LinearLayoutManager mLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        latestMovieList.setLayoutManager(mLayoutManager);
        latestMovieList.setItemAnimator(new DefaultItemAnimator());
        latestMovieList.setAdapter(latestMovieAdapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    private void initPresenter()
    {
        this.presenter.initView(this);
    }

    private void initializeAdapter() {
        popularMovieAdapter = new MoviesAdapter(presenter);
        latestMovieAdapter = new MoviesAdapter(presenter) ;
    }

    private void initDagger()
    {
        YTSApplication app = new YTSApplication();
        app.getComponent().inject(this);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showPopularMovies(List<MovieViewModel> movies) {
        popularMovieAdapter.addAll(movies);
        popularMovieAdapter.notifyDataSetChanged();
    }

    @Override
    public void showLatestMovies(List<MovieViewModel> movies) {
        latestMovieAdapter.addAll(movies);
        latestMovieAdapter.notifyDataSetChanged();
    }


}
