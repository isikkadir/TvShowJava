package com.info.tvshowjava.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TvShowDetails {
    @SerializedName("tvShow")
    @Expose
    private TvShowDetail TvShowDetail;

    public TvShowDetail getTvShow() {
        return TvShowDetail;
    }

    public void setTvShow(TvShowDetail TvShowDetail) {
        this.TvShowDetail = TvShowDetail;
    }
}
