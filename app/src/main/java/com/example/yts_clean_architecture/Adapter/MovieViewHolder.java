package com.example.yts_clean_architecture.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yts_clean_architecture.Home.Presenter.HomePresenter;
import com.example.yts_clean_architecture.Home.ViewModel.MovieViewModel;
import com.example.yts_clean_architecture.R;
import com.squareup.picasso.Picasso;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    private final HomePresenter presenter;
    private ImageView movieImage;
    private TextView movieTitle;
    private TextView movieYear;
    private TextView movieRating;

    public MovieViewHolder(@NonNull View itemView, HomePresenter presenter) {
        super(itemView);
        this.presenter = presenter;
        movieImage = itemView.findViewById(R.id.movie_image);
        movieTitle = itemView.findViewById(R.id.movie_title);
        movieYear = itemView.findViewById(R.id.movie_year);
        movieRating = itemView.findViewById(R.id.movie_rating);


    }

    public void render(MovieViewModel movieViewModel) {
        getImage(movieViewModel.getImage(),movieImage);
        movieTitle.setText(movieViewModel.getTitle());
        movieYear.setText(Integer.toString(movieViewModel.getYear()));
        movieRating.setText(Float.toString(movieViewModel.getRating()));
    }


    public void getImage(String url, ImageView movieImageView)
    {
        Picasso.get().load(url).fit().into(movieImageView);
    }


    private Context getContext() {
        return itemView.getContext();
    }
}
