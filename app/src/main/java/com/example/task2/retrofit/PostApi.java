package com.example.task2.retrofit;

import com.example.task2.data.PostModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PostApi {
     @GET ("movie/popular")
     Call<PostModel> getMovie (@Query("api_key") String api_key ,
                               @Query("page") int pageId);



}
