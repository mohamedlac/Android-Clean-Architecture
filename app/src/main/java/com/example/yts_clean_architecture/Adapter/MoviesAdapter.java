package com.example.yts_clean_architecture.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yts_clean_architecture.Home.Presenter.HomePresenter;
import com.example.yts_clean_architecture.Home.ViewModel.MovieViewModel;
import com.example.yts_clean_architecture.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final HomePresenter presenter;
    private final List<MovieViewModel> movieList;


    public MoviesAdapter(HomePresenter presenter)
    {
        this.presenter = presenter;
        movieList = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_item, viewGroup, false);
        return new MovieViewHolder(view,presenter);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            MovieViewHolder movieViewHolder = (MovieViewHolder) viewHolder;
            MovieViewModel movieViewModel = movieList.get(i);
            movieViewHolder.render(movieViewModel);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void addAll(Collection<MovieViewModel> collection) {
        movieList.addAll(collection);
    }
}
