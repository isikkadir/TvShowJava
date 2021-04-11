package com.info.tvshowjava.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit;
    private static String apiUrl="https://www.episodate.com/api/";

    public static Retrofit getRetrofit(){

        if(retrofit == null){
            retrofit =  new Retrofit.Builder()
                    .baseUrl(apiUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
