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

public class Gravity extends AppCompatActivity implements SensorEventListener{
    Button b1,b2;
    ImageView i1;
    MediaPlayer mp;
    Sensor s;
    SensorManager sm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gravity);
        b1=(Button)findViewById(R.id.button52);
        b2=(Button)findViewById(R.id.button53);
        i1=(ImageView)findViewById(R.id.imageView6);
        mp=MediaPlayer.create(this,R.raw.sh);
        sm=(SensorManager)getSystemService(SENSOR_SERVICE);
        s=sm.getDefaultSensor(Sensor.TYPE_GRAVITY);
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.reset();
                Intent i=new Intent(Gravity.this,Fourth.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.reset();
                Intent i=new Intent(Gravity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.values[0]<1)
        {
            mp.pause();
        }
        else
        {
            mp.start();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK)
        {     mp.reset();
            Intent i=new Intent(Gravity.this,Fourth.class);
            startActivity(i);
            finish();
        }
        return super.onKeyDown(keyCode,event);
    }
}
