package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     private Button button;
     private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textview_id);
        button = findViewById(R.id.button_id);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("NOTHkING, just check it....");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.setting_id1){
            Toast.makeText(MainActivity.this,"Setting is clicked",Toast.LENGTH_SHORT).show();
        }

        if (item.getItemId()==R.id.setting_id2){
            Toast.makeText(MainActivity.this,"Connect is clicked",Toast.LENGTH_SHORT).show();
        }

        if (item.getItemId()==R.id.setting_id3){
            Toast.makeText(MainActivity.this,"Show is clicked",Toast.LENGTH_SHORT).show();
        }

        if (item.getItemId()==R.id.setting_id4){
            Toast.makeText(MainActivity.this,"Delete is clicked",Toast.LENGTH_SHORT).show();
        }

        if (item.getItemId()==R.id.setting_id5){
            Toast.makeText(MainActivity.this,"Turn on is clicked",Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);
    }
}
