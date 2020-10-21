package com.example.task2.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
@Dao
public interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert (Movies movies);
    @Delete
    void delete (Movies movies);
    @Query("SELECT * FROM Add_Movies")
    LiveData<List<Movies>> getMovies();
}
