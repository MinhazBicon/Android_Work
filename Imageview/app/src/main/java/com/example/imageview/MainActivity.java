package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageView1,imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1= findViewById(R.id.imageview1);
        imageView2= findViewById(R.id.imageview2);

        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.imageview1){
            Toast.makeText(MainActivity.this,"Kids",Toast.LENGTH_SHORT).show();
        }
        else if(v.getId()==R.id.imageview2){
            Toast.makeText(MainActivity.this,"Child",Toast.LENGTH_SHORT).show();
        }
    }
}
