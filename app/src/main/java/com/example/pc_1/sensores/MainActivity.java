package com.example.pc_1.sensores;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    TextView encabezado;
    RelativeLayout fondo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        encabezado=(TextView)findViewById(R.id.encabezado);
        encabezado.setTextSize(24);
        fondo=(RelativeLayout)findViewById(R.id.fondo);
        SensorManager miSensor=(SensorManager)getSystemService(SENSOR_SERVICE);
        miSensor.registerListener(this,miSensor.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        int x,y,z;

        x= (int)event.values[0];
        y= (int)event.values[1];
        z=(int)event.values[2];

        encabezado.setText("Valor: "+ x + ","+y+","+z);


            fondo.setBackgroundColor(Color.rgb(x*20,y*20,z*20));

     }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
