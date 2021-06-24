package com.example.newstask.rest;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("top-headlines")
    Call<Response> getLatestNews(@Query("sources") String source, @Query("apiKey") String apiKey);

}
