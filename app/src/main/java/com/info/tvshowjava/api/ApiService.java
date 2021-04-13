package com.info.tvshowjava.api;

import com.info.tvshowjava.models.PopularTvShowsResponse;
import com.info.tvshowjava.models.TvShowDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("most-popular")
    Call<PopularTvShowsResponse> getTvShows_api(@Query("page") int page);

    @GET("show-details")
    Call<TvShowDetails> getTvShowsDetails_api(@Query("q") int showId);

}
