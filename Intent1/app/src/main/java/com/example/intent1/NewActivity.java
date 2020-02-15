package com.example.intent1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {
     private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        textView = findViewById(R.id.txtid);

        Bundle bundle = getIntent().getExtras();

        if (bundle!=null){

         String value = bundle.getString("key");

         textView.setText(value);
        }
    }
}
