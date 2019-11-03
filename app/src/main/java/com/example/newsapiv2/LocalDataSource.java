package com.example.newsapiv2;

import android.content.Context;
import android.content.Entity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;

import com.example.newsapiv2.Room.EntityDB;
import com.example.newsapiv2.Room.NewsDataBAse;
import com.example.newsapiv2.Room.NewsRepository;

public class LocalDataSource extends AsyncTask<Void,Void,Void> {
    NewsRepository newsRepository;
    NewsDataBAse newsDataBAse;

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




    @Override
    protected Void doInBackground(Void... voids) {

       // newsDataBAse.getInstance(context);

        //newsRepository.insertNews();
       /* EntityDB entityDB = new EntityDB();
       entityDB.setAuthor(author);
       entityDB.setName(name);
       entityDB.setDescription(description);
       entityDB.setTitle(title);
       entityDB.setUrlView(url);
       entityDB.setUrlToImage(urlToImage);

       newsDataBAse.getInstance(context).dao().insert(entityDB);*/

        return null;
    }
}
