package com.example.newsapiv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.newsapiv2.API.ApiClient;
import com.example.newsapiv2.API.ApiInterface;
import com.example.newsapiv2.API.Arcticle;
import com.example.newsapiv2.API.News;
import com.example.newsapiv2.Room.NewsRepository;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    public static RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    public static Adapter adapter;

    public static SwipeRefreshLayout swipeRefreshLayout;
    public static String sources = "techcrunch";

    final static String apikey = "156885bf94af406cbe310eb5ef39d6da";
    List<Arcticle> arcticles = new ArrayList<>();
    RemoteDataSource remoteDataSource;
   // public static Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclreview);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));





        remoteDataSource = new RemoteDataSource();
        remoteDataSource.execute();





    }







    @Override
    public void onRefresh() {
        
    }
}
