package com.example.newsapiv2.Room;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.newsapiv2.MainActivity;

import java.util.List;

public class NewsRepository {


    private androidx.lifecycle.LiveData<List<EntityDB>> getAll;
    private DAO dao;
    NewsDataBAse newsDataBAse;
    private String Db_name = "NewsDB";
    Context context;


    public NewsRepository(Context context) {

        this.context = context;


    }

    public  void insertNews(String title,
                            String description,
                            String author,
                            String name,
                            String urlView,
                            String urlToImage){
        EntityDB entityDB  = new EntityDB();
        entityDB.author = author;
        entityDB.description  =description;
        entityDB.name = name;
        entityDB.title = title;
        entityDB.urlToImage = urlToImage;
        entityDB.urlView = urlView;

        insertNews(entityDB);
    }

    void insertNews(final EntityDB entityDB){
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                newsDataBAse.dao().insert(entityDB);
                return null;
            }
        }.execute();
    }

    public void updateNews(final EntityDB entityDB){
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... voids) {
                newsDataBAse.dao().update(entityDB);
                return null;
            }
        }.execute();
    }

    public List<EntityDB> getAllNews(){
        return newsDataBAse.dao().getAll();
    }



}
