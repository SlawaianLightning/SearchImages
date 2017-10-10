package com.example.work.searchimages.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.work.searchimages.R;
import com.example.work.searchimages.presenter.ImagesPresenter;
import com.example.work.searchimages.ui.adapters.ImagesAdapter;
import com.example.work.searchimages.ui.view.ImagesView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.work.searchimages.utills.StringUtils.COLUMNS;
import static com.example.work.searchimages.utills.StringUtils.SEARCH;

public class ImagesActivity extends MvpAppCompatActivity implements ImagesView{

    @InjectPresenter ImagesPresenter presenter;
    @BindView(R.id.rvImages) RecyclerView rvImages;
    @BindView(R.id.pbUpdated) ProgressBar pbUpdated;
    @BindView(R.id.bError) Button bError;
    @BindView(R.id.tvTextError) TextView tvTextError;
    @BindView(R.id.ivBack) ImageView ivBack;
    private GridLayoutManager gridLayoutManager;
    private ImagesAdapter adapter;
    private String q;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        Intent i=getIntent();
        Bundle extras = i.getExtras();
        q=extras.getString(SEARCH,"");
        int column=extras.getInt(COLUMNS,2);
        gridLayoutManager=new GridLayoutManager(ImagesActivity.this,column);
        adapter=new ImagesAdapter(this);
        rvImages.setHasFixedSize(true);
        rvImages.setLayoutManager(gridLayoutManager);
        rvImages.setAdapter(adapter);
        ivBack.setOnClickListener(l->{
            finish();
        });
        presenter.loadImage(q);
    }

    @Override
    public void setData(List<String> images) {
        adapter.updateIm(images);
        bError.setVisibility(View.INVISIBLE);
        tvTextError.setVisibility(View.INVISIBLE);
        pbUpdated.setVisibility(View.INVISIBLE);
        rvImages.setVisibility(View.VISIBLE);
    }

    @Override
    public void load() {
        bError.setVisibility(View.INVISIBLE);
        tvTextError.setVisibility(View.INVISIBLE);
        pbUpdated.setVisibility(View.VISIBLE);
        rvImages.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onError() {
        bError.setVisibility(View.VISIBLE);
        tvTextError.setVisibility(View.VISIBLE);
        pbUpdated.setVisibility(View.INVISIBLE);
        rvImages.setVisibility(View.INVISIBLE);
    }

    @OnClick(R.id.bError)
    public void onErrorClick(View view) {
        presenter.loadImage(q);
    }
}
