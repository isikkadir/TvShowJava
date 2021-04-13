package com.info.tvshowjava.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.info.tvshowjava.R;
import com.info.tvshowjava.databinding.SliderImageBinding;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private String[] images;
    private SliderImageBinding sliderImageBinding;
    LayoutInflater inflater;

    public ImageAdapter(String[] images) {
        this.images = images;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(inflater == null){
            inflater = LayoutInflater.from(parent.getContext());
        }
        SliderImageBinding sliderImageBinding = DataBindingUtil.inflate(inflater, R.layout.slider_image,parent,false);
        return new ImageViewHolder(sliderImageBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.sliderImageBinding.setImageUrl(images[position]);
        holder.sliderImageBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder{
        private SliderImageBinding sliderImageBinding;
        public ImageViewHolder(@NonNull SliderImageBinding sliderImageBinding) {
            super(sliderImageBinding.getRoot());
            this.sliderImageBinding = sliderImageBinding;
        }
    }
}
