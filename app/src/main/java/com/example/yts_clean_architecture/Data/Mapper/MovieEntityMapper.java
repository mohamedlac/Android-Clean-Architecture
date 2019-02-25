package com.example.yts_clean_architecture.Data.Mapper;



import com.example.yts_clean_architecture.Domain.Model.Api.Subs.MovieStruct;
import com.example.yts_clean_architecture.Home.ViewModel.MovieViewModel;


import java.util.ArrayList;
import java.util.List;

public class MovieEntityMapper {



    public MovieEntityMapper()
    {

    }

    public  ArrayList<MovieViewModel> mapTo(List<MovieStruct> data)
    {
        ArrayList<MovieViewModel> movieViewModels = new ArrayList<>();
        for(MovieStruct m : data)
        {
            MovieViewModel movieViewModel = new MovieViewModel(m.getTitle(),
                    m.getImage(),m.getYear(),m.getRating());
            movieViewModels.add(movieViewModel);
        }

        return movieViewModels;
    }

}
