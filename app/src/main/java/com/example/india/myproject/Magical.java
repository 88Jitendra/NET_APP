package com.example.india.myproject;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Magical extends AppCompatActivity implements SensorEventListener {
      Button b1,b2;
      ImageView i1;
     MediaPlayer mp;
    Sensor s;
    SensorManager sm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magical);
        b1=(Button)findViewById(R.id.button23);
        b2=(Button)findViewById(R.id.button42);
        i1=(ImageView)findViewById(R.id.imageView4);
        mp=MediaPlayer.create(this,R.raw.ch);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.reset();
                Intent i=new Intent(Magical.this,Fourth.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.reset();
                Intent i=new Intent(Magical.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
         if(sensorEvent.values[0]>5)
         {
             mp.start();
         }
        else
         {
             mp.pause();
         }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {    mp.reset();
            Intent i=new Intent(Magical.this,Fourth.class);
            startActivity(i);
            finish();
        }
        return super.onKeyDown(keyCode,event);
    }
}
