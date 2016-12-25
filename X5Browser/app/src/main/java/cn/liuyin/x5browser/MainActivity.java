package cn.liuyin.x5browser;


import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.KeyEvent;

import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class MainActivity extends Activity {
    private com.tencent.smtt.sdk.WebView webView;
    //private int width = webView.getView().getWidth();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);
        setContentView(R.layout.activity_main);
        webView=(WebView)findViewById(R.id.webview);
        initWebSetting();
        webView.setWebViewClient(new MyWebViewClient());
        webView.setWebChromeClient(new MyWebChromeClient());
        webView.loadUrl("https://m.baidu.com");


    }
    private void initWebSetting(){
        WebSettings wSet=webView.getSettings();
        wSet.setJavaScriptEnabled(true);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
          if(webView.canGoBack()){
              webView.goBack();
          }
          else {
              finish();
          }

        }
        return true;
    }

    private class MyWebViewClient extends WebViewClient{

    }
    private  class MyWebChromeClient extends WebChromeClient{

    }





}
