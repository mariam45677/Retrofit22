package com.example.task2.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MovieRepository {
    private MovieDao movieDao;
    private LiveData<List<Movies>> allmovies;

    public MovieRepository (Application application) {
        MovieDataBase movieDataBase = MovieDataBase.getInstance(application);
        movieDao = movieDataBase.movieDao();
        allmovies= movieDao.getMovies();
    }
    public void insert(Movies movies){
        new InsertMovieAsyncTask(movieDao).execute(movies);

    }
    public void delete(Movies movies){
        new DeleteMovieAsyncTask(movieDao).execute(movies);

    }
    public LiveData<List<Movies>> getAllmovies() {
        return allmovies;
    }



}
