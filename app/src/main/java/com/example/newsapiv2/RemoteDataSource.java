package com.example.newsapiv2;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;


import com.example.newsapiv2.API.ApiClient;
import com.example.newsapiv2.API.ApiInterface;
import com.example.newsapiv2.API.Arcticle;
import com.example.newsapiv2.API.News;
import com.example.newsapiv2.Room.Adapter1;
import com.example.newsapiv2.Room.EntityDB;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.newsapiv2.MainActivity.apikey;
import static com.example.newsapiv2.MainActivity.recyclerView;

public class RemoteDataSource extends AsyncTask<Void,Void,Void> {


    List<Arcticle> arcticles = new ArrayList<>();
    Context context;
     static String TAG  = "mytag";

    Adapter1 nadapter;
    LocalDataSource localDataSource;
    List<EntityDB> list = new ArrayList<>();




    public static String sources = "techcrunch";


    public RemoteDataSource(Context context) {
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... voids) {


        ApiInterface apiInterface = ApiClient.getAPIClient().create(ApiInterface.class);

        Call<News> call;

        call = apiInterface.getNewsSearch(sources, apikey);

        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {

                if (response.isSuccessful()) {
                    if (!arcticles.isEmpty()) {
                        arcticles.clear();
                    }
                    Log.i("mytag","in onresponse");

                    arcticles = response.body().getArcticles();



                    for (int i = 0; i <arcticles.size() ; i++) {

                        Log.i(TAG, "onResponse:  for  get retrofit data");
                        Arcticle arcticle = arcticles.get(i);
                        String title = arcticle.getTitle();
                        String description = arcticle.getDescription();
                        String author = arcticle.getAuthor();
                        String name = arcticle.getSource().getName();
                        String url = arcticle.getUrl();
                        String urlToImage = arcticle.getUrlToImage();


                        localDataSource = new LocalDataSource(title,
                                description,
                                author,
                                name,
                                url,
                                urlToImage, context);
                        localDataSource.execute();



                    }

                    try {
                         list = localDataSource.get();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    nadapter = new Adapter1(context,list);
                    recyclerView.setAdapter(nadapter);
                    nadapter.notifyDataSetChanged();



                }else {
                    Toast.makeText(context, "Error. Invalid response method\n " +
                            "check your connection", Toast.LENGTH_SHORT).show();
                }



            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {


                Toast.makeText(context, "Failure response", Toast.LENGTH_SHORT).show();
                Exception exception = new Exception();
                exception.printStackTrace();
                Log.i("mytag", exception.toString());
            }
        });




        return null;
    }







}
