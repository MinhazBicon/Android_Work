package com.example.frame_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
     private ImageView imageView_bd,imageView_usa,imageView_china;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView_bd = findViewById(R.id.bangladsh);
        imageView_usa = findViewById(R.id.usa);
        imageView_china = findViewById(R.id.china);

        imageView_bd.setOnClickListener(this);
        imageView_usa.setOnClickListener(this);
        imageView_china.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == imageView_bd){
            imageView_bd.setVisibility(View.INVISIBLE);
            imageView_usa.setVisibility(View.VISIBLE);
        }
        if (v.getId() == R.id.usa){
            imageView_usa.setVisibility(View.INVISIBLE);
            imageView_china.setVisibility(View.VISIBLE);
        }
        if (v.getId() == R.id.china){
            imageView_china.setVisibility(View.INVISIBLE);
            imageView_bd.setVisibility(View.VISIBLE);
        }
    }
}
