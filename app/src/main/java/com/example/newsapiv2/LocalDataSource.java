package com.example.newsapiv2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.newsapiv2.Room.Adapter1;
import com.example.newsapiv2.Room.DAO;
import com.example.newsapiv2.Room.EntityDB;
import com.example.newsapiv2.Room.NewsDataBAse;
import com.example.newsapiv2.Room.NewsRepository;

import java.util.ArrayList;
import java.util.List;

import static com.example.newsapiv2.MainActivity.recyclerView;
import static com.example.newsapiv2.RemoteDataSource.TAG;
import static com.example.newsapiv2.RemoteDataSource.newsDataBAse;

public class LocalDataSource extends AsyncTask<Void, Void, Void> {
    private  DAO dao;
    public static List<EntityDB> listEntity = new ArrayList<>();


    String title, description, author, name, url, urlToImage;
    Context context;


    public LocalDataSource(String title, String description, String author, String name,
                           String url, String urlToImage, Context context) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.name = name;
        this.url = url;
        this.urlToImage = urlToImage;
        this.context = context;
        this.dao = NewsDataBAse.getInstance(context).dao();
    }


    @Override
    protected Void doInBackground(Void... voids) {


        Log.i(TAG, "doInBackground:  LocalDAtaSource");
        EntityDB entityDB = new EntityDB();
        entityDB.setAuthor(author);
        entityDB.setName(name);
        entityDB.setDescription(description);
        entityDB.setTitle(title);
        entityDB.setUrlView(url);
        entityDB.setUrlToImage(urlToImage);

        dao.insert(entityDB);



        listEntity = dao.getAll();
        Log.i(TAG, "doInBackground: "+ listEntity.toString());



        return null;
    }


}
