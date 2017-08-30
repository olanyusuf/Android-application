package com.example.task3.profilecard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends ActionBarActivity {
    private WebView myWebView;
    public static final String DEVELOPER = "lanreYusuf"; // change to ur name
    public static final String EMAIL_SUBJECT = "HNG Internship"; // change the default mail subject
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myWebView = (WebView)findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl("http://hng.fun/profile/lanreyusuf.html");
        myWebView.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if(myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }


    public void sendEmail(View view) {
        String[] recipient = {
                // your email address here
                "lanzer09@gmail.com"
        };

        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, recipient);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, EMAIL_SUBJECT);

        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            emailIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(Intent.createChooser(emailIntent, "Email " + DEVELOPER));
        }
    }
}
