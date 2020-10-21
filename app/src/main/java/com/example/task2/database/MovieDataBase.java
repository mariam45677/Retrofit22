package com.example.task2.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Movies.class},version = 1)

public abstract class MovieDataBase extends RoomDatabase {
    private static MovieDataBase INSTANCE;
   public abstract MovieDao movieDao();
   public static synchronized MovieDataBase getInstance(Context context){
       if (INSTANCE==null){
           INSTANCE = Room.databaseBuilder(context.getApplicationContext(),MovieDataBase.class,"Move_DataBase")
                   .fallbackToDestructiveMigration()
                   .build();

       }
       return INSTANCE;
   }


}
