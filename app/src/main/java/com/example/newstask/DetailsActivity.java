package com.example.newstask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    TextView txt_title1, txt_dec1, txt_aut1, txt_link1, txt_time1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        txt_title1 = findViewById(R.id.txt_title1);
        txt_dec1 = findViewById(R.id.txt_dec1);
        txt_aut1 = findViewById(R.id.txt_aut1);
        txt_link1 = findViewById(R.id.txt_link1);
        txt_time1 = findViewById(R.id.txt_time1);

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

    }
}