package com.example.work.searchimages.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.example.work.searchimages.SearchImagesApp;
import com.example.work.searchimages.data.DataManager;
import com.example.work.searchimages.data.entities.Item;
import com.example.work.searchimages.ui.view.ImagesView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

@InjectViewState
public class ImagesPresenter extends BasePresenter<ImagesView>{
    @Inject DataManager dataManager;
    List<String> images;
    public ImagesPresenter(){
        SearchImagesApp.getAppComponent().inject(this);
    }

    public void loadImage(String q){
        if(images==null) {
            getViewState().load();
            dataManager.getImagesData(q).
                    flatMap(s -> Observable.just(s.getItems())).
                    onErrorResumeNext(Observable.just(null)).
                    observeOn(AndroidSchedulers.mainThread()).
                    subscribe(s -> {
                        if (s == null) {
                            getViewState().onError();
                        } else {
                            List<String> images = new ArrayList<>();
                            for (Item item : s) {
                                images.add(item.getPagemap().getCseImage().get(0).getSrc());
                            }
                            this.images=images;
                            getViewState().setData(images);
                        }
                    });
        }
    }
}
