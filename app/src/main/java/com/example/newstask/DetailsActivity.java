package com.example.newstask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    ImageView image;
    TextView txt_title, txt_dec, txt_aut, txt_link, txt_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        image = findViewById(R.id.image);
        txt_title = findViewById(R.id.txt_title);
        txt_dec = findViewById(R.id.txt_dec);
        txt_aut = findViewById(R.id.txt_aut);
        txt_link = findViewById(R.id.txt_link);
        txt_time = findViewById(R.id.txt_time);

       Details();

    }
    public void Details(){
        final String title = getIntent().getStringExtra("title");
        txt_title.setText(title);
        final String dec = getIntent().getStringExtra("description");
        txt_dec.setText(dec);
        final String aut = getIntent().getStringExtra("author");
        txt_aut.setText(aut);
        final String link = getIntent().getStringExtra("web");
        txt_link.setText(link);
        final String time = getIntent().getStringExtra("time");
        txt_time.setText(time);
    }
}