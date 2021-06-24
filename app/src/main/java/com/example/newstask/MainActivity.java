package com.example.newstask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.newstask.model.Article;
import com.example.newstask.rest.ApiClient;
import com.example.newstask.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String API_KEY = "6ad69394f70947a9f4a83b37864 9a0c8e375ada4198a26f7a52638c4b78";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Response> responseCall = apiService.getLatestNews("google-news",API_KEY);

        responseCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, Response<Response> response) {

            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });

    }
}