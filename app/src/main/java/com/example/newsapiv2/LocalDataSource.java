package com.example.newsapiv2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Entity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;

import com.example.newsapiv2.Room.Adapter1;
import com.example.newsapiv2.Room.EntityDB;
import com.example.newsapiv2.Room.NewsDataBAse;
import com.example.newsapiv2.Room.NewsRepository;

import java.util.List;

import static com.example.newsapiv2.MainActivity.recyclerView;

public class LocalDataSource extends AsyncTask<Void,Void,Void> {
    NewsRepository newsRepository;
     static NewsDataBAse newsDataBAse;
    public Adapter1 adapter;


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
    }




    @SuppressLint("WrongThread")
    @Override
    protected Void doInBackground(Void... voids) {

        List<EntityDB> listDB ;

        //newsRepository.insertNews();
        EntityDB entityDB = new EntityDB();
       entityDB.setAuthor(author);
       entityDB.setName(name);
       entityDB.setDescription(description);
       entityDB.setTitle(title);
       entityDB.setUrlView(url);
       entityDB.setUrlToImage(urlToImage);

       newsDataBAse.getInstance(context).dao().insert(entityDB);



       listDB = newsDataBAse.dao().getAll();
       adapter = new Adapter1(context, listDB);
       recyclerView.setAdapter(adapter);





        return null;
    }





}
