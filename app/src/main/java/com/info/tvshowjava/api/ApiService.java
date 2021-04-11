package com.info.tvshowjava.api;

import com.info.tvshowjava.models.PopularTvShowsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("most-popular")
    Call<PopularTvShowsResponse> getTvShows_api(@Query("page") int page);

}
