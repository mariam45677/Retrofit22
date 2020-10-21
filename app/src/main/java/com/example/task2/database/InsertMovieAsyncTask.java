package com.example.task2.database;

import android.os.AsyncTask;

public class InsertMovieAsyncTask extends AsyncTask<Movies,Void,Void> {
    private MovieDao movieDao;
    public InsertMovieAsyncTask (MovieDao movieDao){
        this.movieDao = movieDao;
    }

    @Override
    protected Void doInBackground(Movies... movies) {
        movieDao.insert(movies[0]);
        return null;
    }
}
