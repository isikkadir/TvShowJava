package com.info.tvshowjava.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.info.tvshowjava.models.TvShowDetails;
import com.info.tvshowjava.repo.TvShowsDetailsRepository;

public class TvShowsDetailsViewModel extends ViewModel {
    private TvShowsDetailsRepository tvShowsDetailsRepository;

    public TvShowsDetailsViewModel() {
        tvShowsDetailsRepository = new TvShowsDetailsRepository();
    }

    public LiveData<TvShowDetails> getTvShowsDetails_viewModel(int showId){
        return  tvShowsDetailsRepository.getTvShowsDetails_repo(showId);
    }
}
