package com.example.logo_toolbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Third_Activity extends AppCompatActivity {
     private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_);

        button = findViewById(R.id.button_bd);
        // adding bak button on toolbar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.remove);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        // parent_Activity declare in the manifest file

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Third_Activity.this,Second_Activity.class);
                startActivity(intent);
            }
        });
    }
}
