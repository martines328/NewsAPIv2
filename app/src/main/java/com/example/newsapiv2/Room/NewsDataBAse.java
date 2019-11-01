package com.example.newsapiv2.Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {EntityDB.class}, version = 1, exportSchema = false)
public abstract class NewsDataBAse extends RoomDatabase {

    public abstract DAO dao();







}
