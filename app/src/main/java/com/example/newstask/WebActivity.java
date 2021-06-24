package com.example.newstask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class WebActivity extends AppCompatActivity {

    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        final String url = getIntent().getStringExtra("url");
        webview = findViewById(R.id.webview);
        webview.loadUrl(url);
    }
}