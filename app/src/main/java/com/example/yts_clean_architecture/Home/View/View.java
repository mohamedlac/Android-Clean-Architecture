package com.example.yts_clean_architecture.Home.View;

import android.content.Context;
import com.example.yts_clean_architecture.Home.ViewModel.MovieViewModel;

import java.util.List;

public interface View {

    Context getContext();

    void showPopularMovies(List<MovieViewModel> movies);

    void showLatestMovies(List<MovieViewModel> movies);

}
