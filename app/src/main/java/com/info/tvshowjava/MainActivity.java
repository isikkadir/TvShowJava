package com.info.tvshowjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.info.tvshowjava.adapters.PopularTvShowsAdapter;
import com.info.tvshowjava.databinding.ActivityMainBinding;
import com.info.tvshowjava.models.PopularTvShows;
import com.info.tvshowjava.models.PopularTvShowsResponse;
import com.info.tvshowjava.viewmodels.PopularTvShowsViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private List<PopularTvShows> popularTvShowsList = new ArrayList<>();
    private PopularTvShowsAdapter adapter;
    private PopularTvShowsViewModel popularTvShowsViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.recyclerView.setHasFixedSize(true);
        adapter = new PopularTvShowsAdapter(popularTvShowsList);
        activityMainBinding.recyclerView.setAdapter(adapter);
        activityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getTvShows_main();

    }
    private void getTvShows_main(){
        popularTvShowsViewModel = new ViewModelProvider(this).get(PopularTvShowsViewModel.class);
        popularTvShowsViewModel.getTvShows_viewModel(1).observe(this,TVShowResponse->{
            Log.e("Main", "Tv show getirilecek");
            popularTvShowsList.addAll(TVShowResponse.getTv_shows());
            Log.e("Main", "" + popularTvShowsList.isEmpty());
            adapter.notifyDataSetChanged();

        });

    }
}