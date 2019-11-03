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
import com.example.newsapiv2.Room.NewsDataBAse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//import static com.example.newsapiv2.MainActivity.adapter;
import static com.example.newsapiv2.MainActivity.apikey;
import static com.example.newsapiv2.MainActivity.recyclerView;
import static com.example.newsapiv2.MainActivity.swipeRefreshLayout;

public class RemoteDataSource extends AsyncTask<Void,Void,Void> {


    List<Arcticle> arcticles = new ArrayList<>();
    public Adapter adapter;
    Context context;
    NewsDataBAse newsDataBAse;
    Intent intent;
    LocalDataSource localDataSource;


    public static String sources = "techcrunch";


    public RemoteDataSource(Context context) {
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... voids) {


        ApiInterface apiInterface = ApiClient.getAPIClient().create(ApiInterface.class);

        Call<News> call;
        Log.i("mytag","in doinbackground");

        call = apiInterface.getNewsSearch(sources, apikey);

        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {

                if (response.isSuccessful()) {
                    if (!arcticles.isEmpty()) {
                        arcticles.clear();
                    }
                    Log.i("mytag","in onresponse");

                  //  swipeRefreshLayout.setRefreshing(false);
                    arcticles = response.body().getArcticles();
                    adapter = new Adapter(arcticles, context);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();



                     newsDataBAse.getInstance(context);


                    for (int i = 0; i <arcticles.size() ; i++) {


                        Arcticle arcticle = arcticles.get(i);
                        String title = arcticle.getTitle();
                        String description = arcticle.getDescription();
                        String author = arcticle.getAuthor();
                        String name = arcticle.getSource().getName();
                        String url = arcticle.getUrl();
                        String urlToImage = arcticle.getUrlToImage();

                      /*  intent.putExtra("title", title.toString());
                        intent.putExtra("description", description.toString());
                        intent.putExtra("author", author.toString());
                        intent.putExtra("name", name.toString());
                        intent.putExtra("url", url.toString());
                        intent.putExtra("urlToImage", urlToImage.toString());
*/

                        localDataSource = new LocalDataSource(title,
                                description,
                                author,
                                name,
                                url,
                                urlToImage, context);
                        localDataSource.execute();



                    }





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
