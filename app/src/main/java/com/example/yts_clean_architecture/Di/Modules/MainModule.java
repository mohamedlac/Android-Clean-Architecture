package com.example.yts_clean_architecture.Di.Modules;


import android.content.Context;

import com.example.yts_clean_architecture.Data.Api.ApiService;
import com.example.yts_clean_architecture.Data.Repository.DataSource.MovieDataSource;
import com.example.yts_clean_architecture.Data.Repository.MoviesRepository;
import com.example.yts_clean_architecture.YTSApplication;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MainModule {

    private static final String BASE_URL="https://yts.am/api/v2/";
    private YTSApplication application;

    public MainModule(YTSApplication application)
    {
        this.application= application;
    }


    @Singleton
    @Provides
    Context provideApplicationContext()
    {
        return application;
    }

    @Provides
    @Singleton
    ApiService provideApiService(Retrofit retrofit)
    {
        return retrofit.create(ApiService.class);

    }

    @Provides
    @Singleton
    MovieDataSource provideMovieDataSource(ApiService apiService)
    {
        return  new MovieDataSource(apiService);

    }

    @Provides
    @Singleton
    MoviesRepository provideMovieRepository(MovieDataSource movieDataSource)
    {
        return new MoviesRepository(movieDataSource);

    }


    @Provides
    @Named("executor_thread")
    Scheduler provideExecutorThread()
    {
        return Schedulers.io();
    }

    @Provides
    @Named("ui_thread")
    Scheduler provideUiThread()
    {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpCLient()
    {
        return new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient,
                             GsonConverterFactory gsonConverterFactory,RxJava2CallAdapterFactory rxAdapter)
    {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(rxAdapter)
                .addConverterFactory(gsonConverterFactory)
                .build();
    }


    @Singleton
    @Provides
    GsonConverterFactory provideGsonConverterFactory()
    {
        return GsonConverterFactory.create();
    }

    @Singleton
    @Provides
    RxJava2CallAdapterFactory provideRxJava2CallAdapterFactory()
    {
        return RxJava2CallAdapterFactory.create();
    }



}
