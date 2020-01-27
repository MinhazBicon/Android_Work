package com.example.toast1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button0, button1,button2,button3;
    int count0=0, count1=0;
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
            Toast.makeText(MainActivity.this,"Clock0 clicked",Toast.LENGTH_LONG).show();
            count0++;
            textView0.setText("Count0= "+count0);
            //Log.d("tag","Clock0 clicked for checking output in console");

        }
        if (v.getId()==R.id.mybutton2){
            Toast.makeText(MainActivity.this,"Clock1 clicked",Toast.LENGTH_SHORT).show();
            count1++;
            textView1.setText("Count1= "+count1);
        }
        if (v.getId()==R.id.mybutton3){
            Toast toast=Toast.makeText(MainActivity.this,"Negative Clock0 clicked",Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,40,40);
            toast.show();
            count0--;
            textView2.setText("Count0= "+count0);
        }
        if (v.getId()==R.id.mybutton4){
            Toast toast= Toast.makeText(MainActivity.this,"Negative Clock1 clicked",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,50,50);
            toast.show();
            count1--;
            textView3.setText("Count1= "+count1);
        }

    }







}


