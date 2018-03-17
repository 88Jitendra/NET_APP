package com.example.india.myproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Second extends AppCompatActivity {
    EditText e1, e2, e3;
    Button b1, b2;
    String s1, s2, s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        e1 = (EditText) findViewById(R.id.editText3);
        e2 = (EditText) findViewById(R.id.editText4);
        e3 = (EditText) findViewById(R.id.editText5);
        b1 = (Button) findViewById(R.id.button3);
        b2 = (Button) findViewById(R.id.button4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Second.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = e1.getText().toString();
                s2 = e2.getText().toString();
                s3 = e3.getText().toString();
                if (s1.equals("") || s2.equals("") || s3.equals("")) {
                    Toast.makeText(Second.this, "Fill all details", Toast.LENGTH_SHORT).show();

                } else {
                    SQLiteDatabase data = openOrCreateDatabase("New", MODE_PRIVATE, null);
                    data.execSQL("create table if not exists camp(name varchar,password varchar,email varchar)");
                    String s4 = "select * from camp where name='" + s1 + "' and password='" + s2 + "' and email='" + s3 + "'";
                    Cursor cursor = data.rawQuery(s4, null);
                    if (cursor.getCount() > 0) {
                        Toast.makeText(Second.this, "User already exists", Toast.LENGTH_SHORT).show();
                    } else {
                        data.execSQL("insert into camp values('" + s1 + "','" + s2 + "','" + s3 + "')");
                        Toast.makeText(Second.this, "DataBase updated and signup successfull", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Second.this, Third.class);
                        startActivity(i);
                        finish();
                    }
                }

            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {
            Intent i=new Intent(Second.this,MainActivity.class);
            startActivity(i);
            finish();
        }
        return super.onKeyDown(keyCode,event);
    }
}
