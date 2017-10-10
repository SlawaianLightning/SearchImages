package com.example.work.searchimages;

import android.app.Application;

import com.example.work.searchimages.data.remote.ApiService;
import com.example.work.searchimages.data.remote.RetroClient;
import com.example.work.searchimages.injection.AppComponents;
import com.example.work.searchimages.injection.AppModule;
import com.example.work.searchimages.injection.DaggerAppComponents;

public class SearchImagesApp extends Application{
    private static AppComponents sAppComponent;
    public static AppComponents getAppComponent() {
        return sAppComponent;
    }
    public static ApiService apiServiceImagesData= RetroClient.getApiServiceImagesData();
    @Override
    public void onCreate() {
        super.onCreate();
        sAppComponent = DaggerAppComponents.builder().appModule(new AppModule(this)).build();
    }
}
