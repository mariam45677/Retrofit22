package com.example.task2.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.task2.database.MovieRepository;
import com.example.task2.database.Movies;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {
    private MovieRepository movieRepository;
    private LiveData<List<Movies>> allmovie;

    public MovieViewModel(@NonNull Application application) {
        super(application);
        movieRepository = new MovieRepository(application);
        allmovie = movieRepository.getAllmovies();
    }
    public LiveData<List<Movies>> getAllmovie(){
        return allmovie;
    }
    public void insert(Movies movies){
        movieRepository.insert(movies);



    }
    public void delete(Movies movies){
        movieRepository.delete(movies);

    }
}
