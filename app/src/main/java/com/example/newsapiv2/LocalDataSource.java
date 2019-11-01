package com.example.newsapiv2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;

import com.example.newsapiv2.Room.NewsRepository;

public class LocalDataSource extends AsyncTask<Void,Void,Void> {
    NewsRepository newsRepository;

    String title, description, author, name, url, urlToImage;
    Context context;



    public LocalDataSource(String title, String description, String author, String name,
                           String url, String urlToImage) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.name = name;
        this.url = url;
        this.urlToImage = urlToImage;
    }




    @Override
    protected Void doInBackground(Void... voids) {

        newsRepository = new NewsRepository();
        newsRepository.insertNews(title,description,author,name,url,urlToImage);



        return null;
    }
}
