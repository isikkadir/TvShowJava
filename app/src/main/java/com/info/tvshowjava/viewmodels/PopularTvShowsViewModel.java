package com.info.tvshowjava.viewmodels;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.info.tvshowjava.models.PopularTvShowsResponse;
import com.info.tvshowjava.repo.PopularTvShowsRepository;

public class PopularTvShowsViewModel extends ViewModel {
    private PopularTvShowsRepository popularTvShowsRepository;
    public PopularTvShowsViewModel(){
        popularTvShowsRepository = new PopularTvShowsRepository();
    }

    public LiveData<PopularTvShowsResponse> getTvShows_viewModel(int page) {
        Log.e("ViewModel", "Tv show getirilecek");
        return popularTvShowsRepository.getTvShows_repo(page);

    }
}
