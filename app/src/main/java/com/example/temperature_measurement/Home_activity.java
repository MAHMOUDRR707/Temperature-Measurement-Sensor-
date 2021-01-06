package com.example.temperature_measurement;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Home_activity extends AppCompatActivity implements SensorEventListener {

    private SensorManager SensorManager;
    private  Boolean isAvaliable ,cf =true ;
    private Sensor temp;
    Button btn1,btn2;
    public float x ;
    TextView temperature;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        getSupportActionBar().hide();
         btn1 = findViewById(R.id.bttn1);
         btn2 = findViewById(R.id.bttn2);
        temperature = findViewById(R.id.txt_chat2);

        SensorManager  = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if (SensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)!=null){
             temp = SensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
            isAvaliable = true;
        }
        else{
            Toast.makeText(Home_activity.this, "Your Device doesn't have this sensor", Toast.LENGTH_SHORT).show();
            isAvaliable =  false;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        x = event.values[0];
        temperature.setText((int) event.values[0] + "C");
        
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    protected void onResume() {

        super.onResume();
        if (isAvaliable){
            SensorManager.registerListener(this,temp,SensorManager.SENSOR_DELAY_NORMAL); }
    }
    protected void onPause() {

        super.onPause();
        if(isAvaliable){
            SensorManager.unregisterListener(this);
        }
    }
    public void btn1(View view) {
        if (cf){
            temperature.setText((int) (x*(9/5)+32) + "F");
            cf =  false;
        }
    }
    public void btn2(View view) {
        if (!cf){
            temperature.setText((int) (x*(5/9)-32) + "C");
            cf = true;
        }


    }

}
