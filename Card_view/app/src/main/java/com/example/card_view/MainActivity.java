package com.example.card_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView school, store, library, hospital;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // finding CardView //
        school = findViewById(R.id.school);
        store = findViewById(R.id.store);
        library = findViewById(R.id.library);
        hospital = findViewById(R.id.hospital);

        //adding listener
        school.setOnClickListener(this);
        store.setOnClickListener(this);
        library.setOnClickListener(this);
        hospital.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == school){
            Intent intent = new Intent(MainActivity.this,school_activity.class);
            startActivity(intent);
        }

        else if (v == store){
            Intent intent = new Intent(MainActivity.this,store_Activity.class);
            startActivity(intent);
        }

        else if (v == hospital){
            Intent intent = new Intent(MainActivity.this,hospital_Activity.class);
            startActivity(intent);
        }

        else if (v == library){
            Intent intent = new Intent(MainActivity.this,library_Activity.class);
            startActivity(intent);
        }

    }
}
