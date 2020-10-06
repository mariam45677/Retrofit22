package com.example.task2.retrofit;

import com.example.task2.data.PostModel;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface PostApi {
     @GET ("movie/popular")
    Call <List<PostModel>> getMovie (@Query("api_key") String api_key ,
                               @QueryMap int pageId);



}
