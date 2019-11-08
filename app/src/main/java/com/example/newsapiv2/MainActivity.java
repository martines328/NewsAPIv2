package com.example.newsapiv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.newsapiv2.API.ApiClient;
import com.example.newsapiv2.API.ApiInterface;
import com.example.newsapiv2.API.Arcticle;
import com.example.newsapiv2.API.News;
import com.example.newsapiv2.Room.EntityDB;
import com.example.newsapiv2.Room.NewsDataBAse;
import com.example.newsapiv2.Room.NewsRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static RecyclerView recyclerView;
    public static SwipeRefreshLayout swipeRefreshLayout;
    RemoteDataSource remoteDataSource;
    static NewsRepository newsRepository;
    NewsAdapter adapter;



    Context context;
    NewsDataBAse newsDataBAse;

    final static String apikey = "156885bf94af406cbe310eb5ef39d6da";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();


        recyclerView = findViewById(R.id.recyclreview);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


        swipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });

        remoteDataSource = new RemoteDataSource(MainActivity.this);
        remoteDataSource.execute();




    }




    void refresh(){
        Toast.makeText(context, "refresh work", Toast.LENGTH_SHORT).show();

    }






}
