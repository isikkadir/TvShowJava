package com.info.tvshowjava.repo;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.info.tvshowjava.api.ApiClient;
import com.info.tvshowjava.api.ApiService;
import com.info.tvshowjava.models.TvShowDetails;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvShowsDetailsRepository {
    private ApiService apiService;

    public TvShowsDetailsRepository() {
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<TvShowDetails> getTvShowsDetails_repo(int showId){
        MutableLiveData<TvShowDetails> data = new MutableLiveData<>();
        apiService.getTvShowsDetails_api(showId).enqueue(new Callback<TvShowDetails>() {
            @Override
            public void onResponse(Call<TvShowDetails> call, Response<TvShowDetails> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<TvShowDetails> call, Throwable t) {
                Log.e("hata repo detail" , "Hata");
                data.setValue(null);
            }
        });
        return data;
    }
}
