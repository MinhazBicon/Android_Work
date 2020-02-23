package com.example.custom_adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //private SearchView searchView;
    private ListView listView;
    private String[] CountryName;
    int[] flag = {
            R.drawable.bangladesh, R.drawable.usa, R.drawable.germany,
            R.drawable.france, R.drawable.china, R.drawable.england,
            R.drawable.oman, R.drawable.brazil, R.drawable.canada,
            R.drawable.russia, R.drawable.italy, R.drawable.japan,
            R.drawable.mexico};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // searchView = findViewById(R.id.Search_id);
        listView = findViewById(R.id.list_view_id);
        CountryName = getResources().getStringArray(R.array.country_name);
        final CustomAdapter adapter = new CustomAdapter(this, CountryName, flag);
        listView.setAdapter(adapter);


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String value0 = CountryName[position];
                String value1 = (String) adapter.getItem(position);
                Toast.makeText(MainActivity.this, value1+" "+value0 + " " + position, Toast.LENGTH_SHORT).show();
                return false;
            }
        });


    }
}


