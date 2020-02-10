package com.example.fontdefault;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     private TextView textView1,textView2,textView3;
     private Typeface typeface1,typeface2,typeface3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.txtid1);
        textView2 = findViewById(R.id.txtid2);
        textView3 = findViewById(R.id.txtid3);

        typeface1 = Typeface.createFromAsset(getAssets(),"19.ttf");
        textView1.setTypeface(typeface1);
        typeface2 = Typeface.createFromAsset(getAssets(),"AlexBrush_Regular.ttf");
        textView2.setTypeface(typeface2);
        typeface3 = Typeface.createFromAsset(getAssets(),"FiraSans_Bold.otf");
        textView3.setTypeface(typeface3);

    }
}
