package com.example.work.searchimages.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.work.searchimages.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImagesAdapter extends RecyclerView.Adapter{
    private List<String> images = new ArrayList<>();
    private LayoutInflater inflater;
    private Context mContext;

    public ImagesAdapter(Context context){
        this.inflater = LayoutInflater.from(context);
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.image, parent, false);
        return new ImageViewHolder(v);
    }

    public void updateIm(List<String> list){
        images.clear();
        images.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ImageViewHolder imageViewHolder=(ImageViewHolder) holder;
        Picasso.with( imageViewHolder.ivIcon.getContext()).
                load(images.get(position)).
                placeholder(R.drawable.default_picture).
                resize(300, 300).
                into(imageViewHolder.ivIcon);
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.ivIcon) ImageView ivIcon;

        ImageViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
