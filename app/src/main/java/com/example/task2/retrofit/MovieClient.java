package com.example.task2.retrofit;

import java.time.Instant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.task2.data.Constant.BASE_URL;

public class MovieClient {

    private PostApi postApi;
    private static Retrofit INSTANCE = null;

    public static Retrofit getClient() {
        if (INSTANCE == null) {
            INSTANCE = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return INSTANCE;
    }


    }




