package com.example.work.searchimages.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.work.searchimages.R;
import com.example.work.searchimages.SearchImagesApp;
import com.example.work.searchimages.data.DataManager;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.work.searchimages.utills.StringUtils.COLUMNS;
import static com.example.work.searchimages.utills.StringUtils.SEARCH;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tvSearch) TextView tvSearch;
    @BindView(R.id.tvCount) TextView tvCount;
    @BindView(R.id.etSearch) EditText etSearch;
    @BindView(R.id.sbCount) SeekBar sbCount;
    @Inject DataManager dataManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        SearchImagesApp.getAppComponent().inject(this);
        sbCount.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tvCount.setText(""+(i+1));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        tvSearch.setOnClickListener(l->{
            if(etSearch.getText().toString().equals("")){
                etSearch.setError("empty field");
                return;
            }
            Intent intent=new Intent(MainActivity.this,ImagesActivity.class);
            intent.putExtra(SEARCH, etSearch.getText().toString());
            intent.putExtra(COLUMNS, Integer.valueOf(tvCount.getText().toString()));
            startActivity(intent);
        });
    }
}
