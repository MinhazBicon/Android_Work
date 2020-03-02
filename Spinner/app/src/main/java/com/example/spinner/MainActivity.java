package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
      private Spinner spinner;
      private String[] item;
      private Button button;
      private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner_id);
        button = findViewById(R.id.button_id);
        textView = findViewById(R.id.textview_id);

        item = getResources().getStringArray(R.array.item);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spnr_layout,R.id.textview_id2,item);
        spinner.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = spinner.getSelectedItem().toString();
                textView.setText(value);
            }
        });
    }
}
