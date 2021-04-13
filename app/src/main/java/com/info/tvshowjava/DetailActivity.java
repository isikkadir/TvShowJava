package com.info.tvshowjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.info.tvshowjava.adapters.ImageAdapter;
import com.info.tvshowjava.databinding.ActivityDetailBinding;
import com.info.tvshowjava.models.PopularTvShows;
import com.info.tvshowjava.models.TvShowDetails;
import com.info.tvshowjava.viewmodels.PopularTvShowsViewModel;
import com.info.tvshowjava.viewmodels.TvShowsDetailsViewModel;

import java.util.List;

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
    }

    private void getTvShowsDetails(PopularTvShows comingPopularTvShows) {
        tvShowsDetailsViewModel.getTvShowsDetails_viewModel(comingPopularTvShows.getId()).observe(this, TvShowDetails ->{
            Log.e("Getirildi" ,"Getirilen : " + TvShowDetails.getTvShow().getUrl());
            loadImages(TvShowDetails.getTvShow().getPictures());

        });
    }
    private void loadImages(String[] images){
        activityDetailBinding.sliderViewPager.setOffscreenPageLimit(1);
        activityDetailBinding.sliderViewPager.setAdapter(new ImageAdapter(images));
        activityDetailBinding.sliderViewPager.setVisibility(View.VISIBLE);
        activityDetailBinding.viewFadingEdge.setVisibility(View.VISIBLE);
    }
}