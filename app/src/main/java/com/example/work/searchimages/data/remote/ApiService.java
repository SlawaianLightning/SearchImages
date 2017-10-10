package com.example.work.searchimages.data.remote;

import com.example.work.searchimages.data.entities.Data;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface ApiService {
    @GET("v1?key=AIzaSyDgTqEsPs9C2lhf1pie2Bm6l58tVl8blU4&cx=010832729871229958196:cpnvpgq4nvg&alt=json&&as_filetype=png")
    public Observable<Data> getImagesData(@Query("q")String q);

}
