package com.example.task2.database;

import android.os.AsyncTask;

public class DeleteMovieAsyncTask extends AsyncTask<Movies,Void,Void> {
    private MovieDao movieDao;
    public DeleteMovieAsyncTask  (MovieDao movieDao){
        this.movieDao = movieDao;
    }

    @Override
    protected Void doInBackground(Movies... movies) {
        movieDao.delete(movies[0]);
        return null;
    }
}
