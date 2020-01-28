package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     private Button button;
     private TextView textView;
     private RadioGroup radioGroup;
     private RadioButton gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.shwbutton);
        radioGroup = findViewById(R.id.Radio);
        textView = findViewById(R.id.txt);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int select= radioGroup.getCheckedRadioButtonId();
                gender = findViewById(select);
               String value = gender.getText().toString();
               textView.setText("You are selected "+value);

            }
        });



    }
}
