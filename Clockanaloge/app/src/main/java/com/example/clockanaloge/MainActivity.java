package com.example.clockanaloge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.TextClock;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
     private TextClock textClock;
     private AnalogClock analogClock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        analogClock = findViewById(R.id.anaclockid);
        textClock = findViewById(R.id.txtclockid);

        analogClock.setOnClickListener(this);
        textClock.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.anaclockid){
            Toast.makeText(MainActivity.this,"Analouge Clock",Toast.LENGTH_SHORT).show();
        }
        else {

            Toast.makeText(MainActivity.this,"Digital Clock",Toast.LENGTH_SHORT).show();
        }

    }
}
