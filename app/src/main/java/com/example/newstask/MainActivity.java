package com.example.newstask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.example.newstask.adapter.MainAdapter;
import com.example.newstask.model.Article;
import com.example.newstask.model.Response;
import com.example.newstask.rest.ApiClient;
import com.example.newstask.rest.ApiInterface;
import com.example.newstask.utils.OnRecyclerViewitemClicklistener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class MainActivity extends AppCompatActivity implements OnRecyclerViewitemClicklistener {

    private static final String API_KEY = "9a0c8e375ada4198a26f7a52638c4b78";
    RecyclerView main_recyclerview;
    private MainAdapter mainAdapter;
    ApiInterface UsersApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_recyclerview = findViewById(R.id.main_recyclerview);
        main_recyclerview.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        UsersApiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<Response> responseCall = UsersApiInterface.getLatestNews("google-news",API_KEY);

        responseCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(response.body().getStatus().equals("ok")) {
                    List<Article> articleList = response.body().getArticles();
                    final MainAdapter mainArticleAdapter = new MainAdapter(articleList);
                    mainArticleAdapter.setOnRecyclerViewItemClickListener(MainActivity.this);
                    main_recyclerview.setAdapter(mainArticleAdapter);

                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });

    }

    @Override
    public void onItemClick(int adapterPosition, View v) {
        switch (v.getId()) {
            case R.id.linearlayout:
                Article article = (Article) v.getTag();
                if(!TextUtils.isEmpty(article.getUrl())) {

                    Intent webActivity = new Intent(this,WebActivity.class);
                    webActivity.putExtra("url",article.getUrl());
                    startActivity(webActivity);
                }
                break;
        }
    }
}