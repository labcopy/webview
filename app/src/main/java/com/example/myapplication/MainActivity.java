package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText t = (EditText) findViewById(R.id.textview);
        Button bt = (Button) findViewById(R.id.button);
        WebView wv = (WebView) findViewById(R.id.web);
        wv.setWebViewClient(new MyBrowser());
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = t.getText().toString();
                wv.loadUrl(url);
            }
        });
    }
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
