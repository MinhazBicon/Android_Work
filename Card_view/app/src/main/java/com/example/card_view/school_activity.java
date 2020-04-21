package com.example.card_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class school_activity extends AppCompatActivity {
    private TextView school;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_activity);

        school  = findViewById(R.id.school_text_view);
        button = findViewById(R.id.school_btn);

        final String name = " 1.Adamji Cantt. Public School\n 2.Milestone School\n 3.Cambrian School";

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                school.setText(name);
            }
        });
    }
}
