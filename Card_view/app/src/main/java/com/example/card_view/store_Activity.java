package com.example.card_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class store_Activity extends AppCompatActivity {
     private TextView store;
     private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_);
        //hiding actionbar
        getSupportActionBar().hide();
        // hiding title bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        button = findViewById(R.id.store_btn);
        store = findViewById(R.id.store_text_view);
        final String name = " 1.Agora Supper Shop\n 2.Mina Bazar\n 3.Shapnaw Supper Shop";

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                store.setText(name);
            }
        });
    }
}
