package com.feluu.pylife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        WebView webView = findViewById(R.id.webView);
        WebSettings webViewSettings = webView.getSettings();
        webViewSettings.setJavaScriptEnabled(true);
        webViewSettings.setBuiltInZoomControls(true);
        webViewSettings.setMediaPlaybackRequiresUserGesture(false);
        webViewSettings.setLoadWithOverviewMode(true);
        webViewSettings.setUseWideViewPort(true);
        webView.getSettings().setDisplayZoomControls(false);

        String data = "<script src=\"https://radioflo.co.uk/player-min.js\"></script><script id=\"radioFloPlayer\">radioFloPlayer.embed({'url': 'http://s1.slotex.pl:7506/stream/','station-name': 'Radio K-69','autoplay': true,'skin': 'windows-dark','width': 300});</script>";
        //webView.loadData("<iframe src=\"https://docs.google.com/spreadsheets/d/e/2PACX-1vRBoBUvzBVF1qcepRIUToGw61iYgpxzkyuO-1ojzkfoBFCGOUhpTWihE1dURb7W-7jPuR4YJI0FJ09f/pubhtml?gid=904893745&amp;single=true&amp;widget=true&amp;headers=false\"></iframe>", "text/html", "utf-8");
        //webView.loadData(data, "text/html", "UTF-8");
        //webView.loadUrl("https://docs.google.com/spreadsheets/d/e/2PACX-1vRBoBUvzBVF1qcepRIUToGw61iYgpxzkyuO-1ojzkfoBFCGOUhpTWihE1dURb7W-7jPuR4YJI0FJ09f/pubhtml?gid=904893745&single=true");
        //webView.loadUrl("https://k69.pl/odtwarzacz/odtwarzacz.html");
        webView.loadDataWithBaseURL(null, data,"text/html","utf-8", null);
    }
}