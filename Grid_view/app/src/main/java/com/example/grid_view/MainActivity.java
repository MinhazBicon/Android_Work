package com.example.grid_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     private GridView gridView;
    int[] flag = {
            R.drawable.bangladesh, R.drawable.flag, R.drawable.germany,
            R.drawable.france, R.drawable.china, R.drawable.england,
            R.drawable.oman, R.drawable.brazil, R.drawable.canada,
            R.drawable.russia, R.drawable.italy, R.drawable.japan,
            R.drawable.mexico, R.drawable.art};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridview_id);
        final String[] countryname = getResources().getStringArray(R.array.country_name);
        customAdapter adapter = new customAdapter(this,countryname,flag);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = countryname[position];
                Toast.makeText(MainActivity.this,value,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
