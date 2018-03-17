package com.example.india.myproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1, b2;
    EditText e1, e2;
    String s1, s2, s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Second.class);
                startActivity(i);
                finish();
            }

        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = e1.getText().toString();
                s2 = e2.getText().toString();

                if (s1.equals("") || s2.equals("")) {
                    Toast.makeText(MainActivity.this, "Fill all details", Toast.LENGTH_SHORT).show();

                } else {
                    SQLiteDatabase data = openOrCreateDatabase("New", MODE_PRIVATE, null);
                    data.execSQL("create table if not exists camp(name varchar,password varchar,email varchar)");
                    String s4 = "select * from camp where name='" + s1 + "' and password='" + s2 + "'";
                    Cursor cursor = data.rawQuery(s4, null);
                    if (cursor.getCount() > 0) {
                        Toast.makeText(MainActivity.this, "Login successfull", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this, Third.class);
                        startActivity(i);
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, "Please signup", Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });
    }
}
