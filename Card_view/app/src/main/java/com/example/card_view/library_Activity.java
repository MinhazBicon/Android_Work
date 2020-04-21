package com.example.card_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class library_Activity extends AppCompatActivity {
    private TextView library;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_);

        library = findViewById(R.id.library_text_view);
        button = findViewById(R.id.library_btn);
        final String name =" 1.Dhaka Central Library\n 2.Jahangir Nagar Library\n 3.yhWalking Library";

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                library.setText(name);
            }
        });
    }
}
