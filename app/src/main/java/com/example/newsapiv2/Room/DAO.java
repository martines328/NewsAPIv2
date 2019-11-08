package com.example.newsapiv2.Room;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DAO {



    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(EntityDB entityDB);

    @Query("SELECT * FROM news_table")
     List<EntityDB> getAll();

    @Update
    void update(EntityDB entityDB);






}
