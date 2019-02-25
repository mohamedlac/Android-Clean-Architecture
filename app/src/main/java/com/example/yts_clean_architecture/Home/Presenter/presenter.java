package com.example.yts_clean_architecture.Home.Presenter;

import com.example.yts_clean_architecture.Home.View.View;

public interface presenter {

    View getView();

    void initView(View v);

    void initialize();

    void onDestroy();

}
