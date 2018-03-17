package com.example.india.myproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class Calculator extends AppCompatActivity {
    EditText e1, e2;
    Button b1, b2, b3, b4, b5, b6, b7, b8;
    TextView t1;
    String s1, s2, s3;
    Float i1, i2, i3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);setContentView(R.layout.activity_calculator);

        e1 = (EditText) findViewById(R.id.editText6);
        e2 = (EditText) findViewById(R.id.editText7);
        t1 = (TextView) findViewById(R.id.textView);
        b1 = (Button) findViewById(R.id.button14);
        b2 = (Button) findViewById(R.id.button40);
        b3 = (Button) findViewById(R.id.button15);
        b4 = (Button) findViewById(R.id.button16);
        b5 = (Button) findViewById(R.id.button17);
        b6 = (Button) findViewById(R.id.button18);
        b8 = (Button) findViewById(R.id.button19);
        b7 = (Button) findViewById(R.id.button20);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Calculator.this, Third.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Calculator.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                s1 = e1.getText().toString();
                s2 = e2.getText().toString();
                if(s1.equals("")|| s2.equals(""))
                {
                    Toast.makeText(Calculator.this, "ENTER THE NUMBERS", Toast.LENGTH_SHORT).show();
                }
                else {


                    i1 = Float.parseFloat(s1);
                    i2 = Float.parseFloat(s2);
                    i3 = i1 + i2;
                    s3 = Float.toString(i3);
                }

            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = e1.getText().toString();
                s2 = e2.getText().toString();
                if(s1.equals("")|| s2.equals(""))
                {
                    Toast.makeText(Calculator.this, "ENTER THE NUMBERS", Toast.LENGTH_SHORT).show();
                }
                else {
                    i1 = Float.parseFloat(s1);
                    i2 = Float.parseFloat(s2);
                    i3 = i1 - i2;
                    s3 = Float.toString(i3);
                }

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = e1.getText().toString();
                s2 = e2.getText().toString();
                if(s1.equals("")|| s2.equals(""))
                {
                    Toast.makeText(Calculator.this, "ENTER THE NUMBERS", Toast.LENGTH_SHORT).show();
                }
                else {
                    i1 = Float.parseFloat(s1);
                    i2 = Float.parseFloat(s2);
                    i3 = i1 * i2;
                    s3 = Float.toString(i3);
                }

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = e1.getText().toString();
                s2 = e2.getText().toString();
                if(s1.equals("")|| s2.equals(""))
                {
                    Toast.makeText(Calculator.this, "ENTER THE NUMBERS", Toast.LENGTH_SHORT).show();
                }
                else {
                    i1 = Float.parseFloat(s1);
                    i2 = Float.parseFloat(s2);
                    i3 = i1 / i2;
                    s3 = Float.toString(i3);
                }

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText(s3);
            }
        });
         b4.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 e1.setText("");
                 e2.setText("");
                 t1.setText("");
             }
         });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            Intent i=new Intent(Calculator.this,Third.class);
            startActivity(i);
            finish();
        }
        return super.onKeyDown(keyCode,event);
    }
}



