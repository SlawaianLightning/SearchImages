package com.example.work.searchimages.data;

import com.example.work.searchimages.data.entities.Data;

import rx.Observable;

import static com.example.work.searchimages.SearchImagesApp.apiServiceImagesData;

public class DataManager {
    public Observable<Data> getImagesData(String q){
        return apiServiceImagesData.getImagesData(q);
    }
}
