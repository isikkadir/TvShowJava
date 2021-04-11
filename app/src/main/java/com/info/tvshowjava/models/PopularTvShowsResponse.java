package com.info.tvshowjava.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PopularTvShowsResponse {
    public PopularTvShowsResponse() {
    }

    public PopularTvShowsResponse(String total, String page, String pages, List<PopularTvShows> tv_shows) {
        this.total = total;
        this.page = page;
        this.pages = pages;
        this.tv_shows = tv_shows;
    }

    @SerializedName("total")
    @Expose
    private String total;

    @SerializedName("page")
    @Expose
    private String page;

    @SerializedName("pages")
    @Expose
    private String pages;

    @SerializedName("tv_shows")
    @Expose
    private List<PopularTvShows> tv_shows;

    public String getTotal() {
        return total;
    }

    public String getPage() {
        return page;
    }

    public String getPages() {
        return pages;
    }

    public List<PopularTvShows> getTv_shows() {
        return tv_shows;
    }
}
