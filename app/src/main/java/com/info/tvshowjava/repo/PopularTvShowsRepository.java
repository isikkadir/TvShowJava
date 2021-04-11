package com.info.tvshowjava.repo;

import android.util.Log;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.info.tvshowjava.api.ApiClient;
import com.info.tvshowjava.api.ApiService;
import com.info.tvshowjava.models.PopularTvShowsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PopularTvShowsRepository {
    private ApiService apiService;
    public PopularTvShowsRepository() {
        Log.e("Repo", "ApiService create");
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }



    public LiveData<PopularTvShowsResponse> getTvShows_repo(int page) {
        Log.e("Repo", "getTvShows_repo");
        MutableLiveData<PopularTvShowsResponse> data = new  MutableLiveData<>();
        apiService.getTvShows_api(page).enqueue(new Callback<PopularTvShowsResponse>() {
            @Override
            public void onResponse(Call<PopularTvShowsResponse> call, Response<PopularTvShowsResponse> response) {
                Log.e("Repo", "Tv show getirilecek");
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<PopularTvShowsResponse> call, Throwable t) {
                Log.e("Repo", "HATA");
                data.setValue(null);
            }
        });
        return data;
    }


}
