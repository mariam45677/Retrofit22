package com.example.task2.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Add_Movies")

public class Movies {
    @PrimaryKey(autoGenerate = true)
    private int page;
    private int total_results;
    private int total_pages;
    private  double vote_average;
    private String title;
    private String poster_path;

    public Movies(Integer id, Integer vote_count, String poster_path, String title, double vote_average) {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public Movies(int page, int total_results, int total_pages, double vote_average, String title, String poster_path) {
        this.page = page;
        this.total_results = total_results;
        this.total_pages = total_pages;
        this.vote_average = vote_average;
        this.title = title;
        this.poster_path = poster_path;
    }
}
