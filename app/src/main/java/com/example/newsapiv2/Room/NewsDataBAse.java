package com.example.newsapiv2.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {EntityDB.class}, version = 1, exportSchema = false)
public abstract class NewsDataBAse extends RoomDatabase {

    public abstract DAO dao();
    private NewsDataBAse INSTANCE;
    private String Db_name = "NewsDB";

    public NewsDataBAse getInstance(Context context){
        if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(context,NewsDataBAse.class,
              Db_name).build();
        }
        return INSTANCE;

    }







}
