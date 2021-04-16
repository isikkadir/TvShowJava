package com.info.tvshowjava.utilies;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

import java.util.Locale;

public class BindingAdapters {

    @BindingAdapter("android:imageUrl")
    public static void setImageURL(ImageView imageView, String URL){
        Picasso.get()
                .load(URL)
                .noFade()
                .fit()
                .into(imageView);
    }
    @BindingAdapter("android:textRating")
    public static void setStringFormat(TextView textView , String rating){
        textView.setText(String.format(Locale.getDefault(),"%.2f" , Double.parseDouble(rating)));
    }
}
