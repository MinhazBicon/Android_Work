package com.example.button_on3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     private Button button0, button1,button2,button3;
     int count0=0,count1=0;
     private TextView textView0,textView1,textView2,textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0= findViewById(R.id.mybutton1);
        button1= findViewById(R.id.mybutton2);
        button2= findViewById(R.id.mybutton3);
        button3= findViewById(R.id.mybutton4);
        textView0= findViewById(R.id.mytext0);
        textView1= findViewById(R.id.mytext1);
        textView2= findViewById(R.id.mytext2);
        textView3= findViewById(R.id.mytext3);
    }

    public void showmsg(View v){

        if (v.getId()==R.id.mybutton1){
             count0++;
             textView0.setText("gjdgngkss...."+count0+"ssvsv");
            }

        if (v.getId()==R.id.mybutton2){
            count1++;
            textView1.setText("gjdgngkss...."+count1+"ssvsv");
        }

        if (v.getId()==R.id.mybutton3){
            count0--;
            textView2.setText("dgghhhdhd...."+count0+"ssvsv");
        }
        if (v.getId()==R.id.mybutton4){
            count1--;
            textView3.setText("khhrhfhf...."+count1+"ssvsv");
        }





    }



    }

