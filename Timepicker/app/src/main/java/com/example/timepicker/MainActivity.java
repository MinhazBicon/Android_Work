package com.example.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
     private TextView textView;
     private Button button;
     private TimePicker timePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txtid);
        button = findViewById(R.id.buttonid);
        timePicker = findViewById(R.id.timeid);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time  = timePicker.getCurrentHour()+":"+timePicker.getCurrentMinute();

                textView.setText(time);
            }
        });

    }
}
