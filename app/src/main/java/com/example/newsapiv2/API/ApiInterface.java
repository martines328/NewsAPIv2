package com.example.newsapiv2.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {


    @GET("top-headlines")
    Call<News> getNewsSearch(


            @Query("sources") String sources,
            @Query("apiKey") String apiKey


    );



}
