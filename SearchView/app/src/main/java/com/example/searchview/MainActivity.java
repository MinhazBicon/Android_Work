package com.example.searchview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {
     private ListView listView;
     private ArrayAdapter<String> arrayAdapter;
     private String[] name;
     private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.searchid);
        listView = findViewById(R.id.ListView);
        name = getResources().getStringArray(R.array.list_items);
        arrayAdapter = new ArrayAdapter<String>(MainActivity.this,R.layout.new_layout,R.id.textview_id,name);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemLongClickListener(this);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapter.getFilter().filter(newText);

                return false;
            }
        });

    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        String value = arrayAdapter.getItem(position);
        Toast.makeText(MainActivity.this,value+" "+position,Toast.LENGTH_SHORT).show();
        return true;
    }
}
