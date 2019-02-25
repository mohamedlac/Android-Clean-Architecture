package com.example.yts_clean_architecture.Di.Components;


import android.content.Context;

import com.example.yts_clean_architecture.Di.Modules.MainModule;
import com.example.yts_clean_architecture.Home.View.HomeActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = MainModule.class)
public interface AppComponent {

    void inject(HomeActivity homeActivity);

    Context context();
}