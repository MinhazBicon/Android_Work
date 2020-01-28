package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     private Button button;
     private CheckBox milk,sugar,flower,water;
     private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        milk = findViewById(R.id.Milkcheck);
        flower = findViewById(R.id.Flowerrcheck);
        sugar = findViewById(R.id.Sugarcheck);
        water = findViewById(R.id.Watercheck);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();

                if (milk.isChecked()){

                    String value = milk.getText().toString();
                    stringBuilder.append(value + " is ordered!!"+"\n");
                }
                if (flower.isChecked()){

                    String value = flower.getText().toString();
                    stringBuilder.append(value + " is ordered!!"+"\n");
                }
                if (sugar.isChecked()){

                    String value = sugar.getText().toString();
                    stringBuilder.append(value + " is ordered!!"+"\n");
                }
                if (water.isChecked()){

                    String value = water.getText().toString();
                    stringBuilder.append(value + " is ordered!!"+"\n");
                }
                textView.setText(stringBuilder);

            }
        });



    }
}
