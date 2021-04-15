package com.info.tvshowjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.info.tvshowjava.adapters.ImageAdapter;
import com.info.tvshowjava.databinding.ActivityDetailBinding;
import com.info.tvshowjava.models.PopularTvShows;
import com.info.tvshowjava.models.TvShowDetails;
import com.info.tvshowjava.viewmodels.PopularTvShowsViewModel;
import com.info.tvshowjava.viewmodels.TvShowsDetailsViewModel;

import java.util.List;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding activityDetailBinding;
    private TvShowsDetailsViewModel tvShowsDetailsViewModel;
    private PopularTvShows comingPopularTvShows;
    private ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        initialize();
        getTvShowsDetails(comingPopularTvShows);

    }

    private void initialize() {
        Intent getIntent = getIntent();
        comingPopularTvShows = (PopularTvShows) getIntent.getSerializableExtra("tvShow");
        tvShowsDetailsViewModel = new ViewModelProvider(this).get(TvShowsDetailsViewModel.class);
        activityDetailBinding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void getTvShowsDetails(PopularTvShows comingPopularTvShows) {
        tvShowsDetailsViewModel.getTvShowsDetails_viewModel(comingPopularTvShows.getId()).observe(this, TvShowDetails -> {
            Log.e("Getirildi", "Getirilen : " + TvShowDetails.getTvShow().getUrl());
            loadImages(TvShowDetails.getTvShow().getPictures());

        });
    }

    private void loadImages(String[] images) {
        activityDetailBinding.sliderViewPager.setOffscreenPageLimit(1);
        activityDetailBinding.sliderViewPager.setAdapter(new ImageAdapter(images));
        activityDetailBinding.sliderViewPager.setVisibility(View.VISIBLE);
        activityDetailBinding.viewFadingEdge.setVisibility(View.VISIBLE);
        setupSliderIndicator(images.length);
        activityDetailBinding.sliderViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentSliderIndicator(position);
            }
        });
    }

    private void setupSliderIndicator(int count) {
        ImageView[] indicators = new ImageView[count];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);
        layoutParams.setMargins(8, 0, 8, 0);
        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getApplicationContext());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),
                    R.drawable.slider_images_deactive));
            indicators[i].setLayoutParams(layoutParams);
            activityDetailBinding.linearLayout.addView(indicators[i]);
        }
        activityDetailBinding.linearLayout.setVisibility(View.VISIBLE);
        setCurrentSliderIndicator(0);
    }

    private void setCurrentSliderIndicator(int position) {
        int childCount = activityDetailBinding.linearLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) activityDetailBinding.linearLayout.getChildAt(i);
            if (i == position) {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(),
                                R.drawable.slider_images_active)
                );
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),
                        R.drawable.slider_images_deactive));
            }
        }
    }
}