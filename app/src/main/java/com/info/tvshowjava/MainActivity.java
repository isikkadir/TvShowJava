package com.info.tvshowjava;

import androidx.annotation.NonNull;
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

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {
    String TAG = "Main";
    private ActivityMainBinding activityMainBinding;
    private List<PopularTvShows> popularTvShowsList = new ArrayList<>();
    private PopularTvShowsAdapter adapter;
    private PopularTvShowsViewModel popularTvShowsViewModel;
    private int currentPage;
    private int totalPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initialize();

        getTvShows_main();

    }

    private void initialize() {
        currentPage = 1;
        activityMainBinding.recyclerView.setHasFixedSize(true);
        adapter = new PopularTvShowsAdapter(popularTvShowsList);
        activityMainBinding.recyclerView.setAdapter(adapter);
        activityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        activityMainBinding.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (!activityMainBinding.recyclerView.canScrollVertically(1)) {
                    if (currentPage <= totalPage) {
                        currentPage += 1;
                        getTvShows_main();
                    }
                }
            }
        });
        getTvShows_main();

    }

    private void getTvShows_main() {
        activityMainBinding.setIsLoadingMore(true);
        popularTvShowsViewModel = new ViewModelProvider(this).get(PopularTvShowsViewModel.class);
        popularTvShowsViewModel.getTvShows_viewModel(currentPage).observe(this, TVShowResponse -> {
            totalPage = parseInt(TVShowResponse.getPages());
            activityMainBinding.setIsLoadingMore(false);
            if (TVShowResponse != null) {
                if (TVShowResponse.getTv_shows() != null) {
                    int oldCount = popularTvShowsList.size();
                    Log.e(TAG, "Liste eleman sayısı : " + popularTvShowsList.size());

                    popularTvShowsList.addAll(TVShowResponse.getTv_shows());
                    adapter.notifyDataSetChanged();
                }
            }
        });

    }
}