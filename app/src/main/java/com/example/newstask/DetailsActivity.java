package com.example.newstask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.newstask.model.Article;

public class DetailsActivity extends AppCompatActivity {
    TextView txt_title1, txt_dec1, txt_aut1, txt_link1, txt_time1;
    ImageView img_news;
    String img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        txt_title1 = findViewById(R.id.txt_title1);
        txt_dec1 = findViewById(R.id.txt_dec1);
        txt_aut1 = findViewById(R.id.txt_aut1);
        txt_link1 = findViewById(R.id.txt_link1);
        txt_time1 = findViewById(R.id.txt_time1);
        img_news = findViewById(R.id.img_news);
        Details();

    }
    public void Details(){
        final String title = getIntent().getStringExtra("title");
        txt_title1.setText(title);
        final String dec = getIntent().getStringExtra("description");
        txt_dec1.setText(dec);
        final String aut = getIntent().getStringExtra("author");
        txt_aut1.setText(aut);
        final String link = getIntent().getStringExtra("web");
        txt_link1.setText(link);
        final String time = getIntent().getStringExtra("time");
        txt_time1.setText(time);
        img = getIntent().getStringExtra("image");
        Glide.with(this).load(img).into(img_news);

        img_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ImageActivity.class);
                intent.putExtra("image",img);
                startActivity(intent);
            }
        });
        txt_link1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent webView = new Intent(getApplicationContext(),WebActivity.class);
                    webView.putExtra("url",link);
                    startActivity(webView);
            }
        });
    }
}