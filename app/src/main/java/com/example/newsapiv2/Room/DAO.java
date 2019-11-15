package com.example.newsapiv2.Room;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DAO {



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(EntityDB entityDB);

    @Query("SELECT * FROM news_table")
     List<EntityDB> getAll();


    @Delete
    void delete(EntityDB entityDB);


    @Update
    void update(EntityDB entityDB);






}
