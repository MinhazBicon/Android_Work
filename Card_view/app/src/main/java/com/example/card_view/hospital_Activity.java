package com.example.card_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class hospital_Activity extends AppCompatActivity {
     private TextView hospital;
     private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_);

        hospital = findViewById(R.id.hospital_text_view);
        button = findViewById(R.id.hospital_btn);
        final String name =" 1.Appolo Hospital Ltd.\n 2.United Hospital Ltd.\n 3.Square Hospital Ltd.";

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hospital.setText(name);
            }
        });

    }
}
