package com.example.yts_clean_architecture;

import android.app.Application;

import com.example.yts_clean_architecture.Di.Components.AppComponent;
import com.example.yts_clean_architecture.Di.Components.DaggerAppComponent;
import com.example.yts_clean_architecture.Di.Modules.MainModule;

public class YTSApplication extends Application {

    private AppComponent component;


    public YTSApplication()
    {
            component = DaggerAppComponent.builder().mainModule(new MainModule(this)).build();
    }

    public AppComponent getComponent()
    {
        return component;
    }



}
