package com.example.zigzag.src.order;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.zigzag.R;

public class RoadadressActivity extends AppCompatActivity {
    private WebView daum_webView;

    private String daum_result;

    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roadadress);


        daum_result = "";


        // WebView 초기화
        //init_webView();


        // 핸들러를 통한 JavaScript 이벤트 반응

        //handler = new Handler();
    }
    public void init_webView() {

        // WebView 설정

        daum_webView = (WebView) findViewById(R.id.webView_address);


        // JavaScript 허용

        daum_webView.getSettings().setJavaScriptEnabled(true);


        // JavaScript의 window.open 허용

        daum_webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);


        // JavaScript이벤트에 대응할 함수를 정의 한 클래스를 붙여줌

        daum_webView.addJavascriptInterface(new AndroidBridge(), "zigzag");


        // web client 를 chrome 으로 설정

        daum_webView.setWebChromeClient(new WebChromeClient());


        // webview url load. php 파일 주소

        daum_webView.loadUrl("http://15.164.29.242/daum_address.php");

    }


    private class AndroidBridge {

        @JavascriptInterface

        public void setAddress(final String arg1, final String arg2, final String arg3) {

            handler.post(new Runnable() {

                @Override

                public void run() {

                    //daum_result.setText(String.format("(%s) %s %s", arg1, arg2, arg3));
                    daum_result=arg1+arg2+arg3;
                    // WebView를 초기화 하지않으면 재사용할 수 없음

                    init_webView();

                }

            });

        }

    }
}
