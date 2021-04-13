package com.info.tvshowjava.utilies;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public class BindingAdapters {

    @BindingAdapter("android:imageUrl")
    public static void setImageURL(ImageView imageView, String URL){
        Picasso.get()
                .load(URL)
                .noFade()
                .fit()
                .into(imageView);
    }
}
