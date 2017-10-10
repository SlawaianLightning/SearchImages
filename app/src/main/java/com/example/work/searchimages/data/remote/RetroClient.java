package com.example.work.searchimages.data.remote;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

public class RetroClient {
    private static final String baseUrl="https://www.googleapis.com/customsearch/";

    private static Retrofit getRetrofitInstaceImagesSearch(){
        return new Retrofit.Builder().baseUrl(baseUrl).
                addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    public static ApiService getApiServiceImagesData(){
        return getRetrofitInstaceImagesSearch().create(ApiService.class);
    }
}
