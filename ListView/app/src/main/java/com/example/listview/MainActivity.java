package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= findViewById(R.id.List_view_id);
        final String[] CountryName;
        CountryName = getResources().getStringArray(R.array.country_name);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.country_name_layout, R.id.text_view_id, CountryName);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String value= CountryName[position];
                Toast.makeText(MainActivity.this,value+position,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
