package com.example.dell_pc.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main2Activity extends AppCompatActivity {

    private WebView wb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        wb = (WebView) findViewById(R.id.wb);
        wb.loadUrl("https://www.baidu.com/");
        wb.setWebViewClient(new WebViewClient());
    }
}
