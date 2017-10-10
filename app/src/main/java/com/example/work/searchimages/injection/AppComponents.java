package com.example.work.searchimages.injection;


import com.example.work.searchimages.presenter.ImagesPresenter;
import com.example.work.searchimages.ui.activities.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {AppModule.class, ReceiversModule.class})
@Singleton
public interface AppComponents {
    public void inject(ImagesPresenter presenter);
    public void inject(MainActivity presenter);
}
