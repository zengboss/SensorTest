package com.example.sensortest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private TextView textview1;
    private TextView textview2;
    private TextView textview3;

    private SensorManager sensorManager;
    private Sensor mOrientation;

    private LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


    //github commit test
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);


        mOrientation = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        sensorManager.registerListener(this,mOrientation,SensorManager.SENSOR_DELAY_UI);
        bindViews();
    }

    private void bindViews(){
        textview1 = findViewById(R.id.textView3);
        textview2 = findViewById(R.id.textView4);
        textview3 = findViewById(R.id.textView5);
    }



    @Override
    public void onSensorChanged(SensorEvent event) {
        textview1.setText("方位角：" + (float) (Math.round(event.values[0] * 100)) / 100);
        textview2.setText("倾斜角：" + (float) (Math.round(event.values[1] * 100)) / 100);
        textview3.setText("滚动角：" + (float) (Math.round(event.values[2] * 100)) / 100);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}