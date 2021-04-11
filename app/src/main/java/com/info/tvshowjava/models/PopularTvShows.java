package com.info.tvshowjava.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PopularTvShows {

    public PopularTvShows() {
    }

    public PopularTvShows(int id, String name, String start_date, String end_date, String country, String network, String status, String image_thumbnail_path) {
        this.id = id;
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.country = country;
        this.network = network;
        this.status = status;
        this.image_thumbnail_path = image_thumbnail_path;
    }

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("start_date")
    @Expose
    private String start_date;

    @SerializedName("end_date")
    @Expose
    private String end_date;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("network")
    @Expose
    private String network;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("image_thumbnail_path")
    @Expose
    private String image_thumbnail_path;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public String getCountry() {
        return country;
    }

    public String getNetwork() {
        return network;
    }

    public String getStatus() {
        return status;
    }

    public String getImage_thumbnail_path() {
        return image_thumbnail_path;
    }
}
