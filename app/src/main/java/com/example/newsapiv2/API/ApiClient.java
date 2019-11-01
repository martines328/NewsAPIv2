package com.example.newsapiv2.API;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient  {


    public static final String baseAPI = "https://newsapi.org/v2/";
    public static Retrofit retrofit;

    public static Retrofit getAPIClient(){





        if (retrofit == null){

            retrofit = new Retrofit.Builder()
                    .baseUrl(baseAPI)
                    .client(new OkHttpClient.Builder().build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


        }


        return retrofit;
    }


}
