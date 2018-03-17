package com.example.india.myproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class Quiz6 extends AppCompatActivity {
     Button b1,b2,b3,b4,b5;
    TextView t1;
    String s1;
    WebView w1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz6);
        b1=(Button)findViewById(R.id.button35);
        b2=(Button)findViewById(R.id.button36);
        b3=(Button)findViewById(R.id.button37);
        b4=(Button)findViewById(R.id.button47);
        b5=(Button)findViewById(R.id.button38);
        t1=(TextView)findViewById(R.id.textView7);
        w1=(WebView)findViewById(R.id.webView);
          s1=Integer.toString(Quiz1.score);
        t1.setText("Ur result is " + s1);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Quiz6.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Quiz6.this,Third.class);
                startActivity(i);
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             w1.loadUrl("https://www.facebook.com");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                w1.loadUrl("https://www.twitter.com");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                w1.loadUrl("https://www.google.com");
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            Intent i=new Intent(Quiz6.this,Quiz5.class);
            startActivity(i);
            finish();
        }
        return super.onKeyDown(keyCode,event);
    }
}
