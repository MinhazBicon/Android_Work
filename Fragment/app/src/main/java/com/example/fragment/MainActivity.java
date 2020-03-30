package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
     private ListView listView;
     private Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] Virus_name = {"Influenza","HIV virus","Aichi virus","Chikungunya","Cosavirus A","Cowpox virus",
                               "Dhori virus","Dugbe virus","Hantaan virus","Novel Coronavirus"};

        listView = findViewById(R.id.list_view_id);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Virus_name);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
       // fragment =new default_fragment();
       // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_id,fragment).commit();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0){
            fragment = new influenza_fragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_id,fragment);
            fragmentTransaction.commit();
        }
        else if (position == 1) {
            fragment = new hiv_fragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_id, fragment).commit();
        }
        else if (position == 2) {
            fragment = new aichi_fragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_id, fragment).commit();
        }
        else if (position == 3) {
            fragment = new Chikungunya_fragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_id, fragment).commit();
        }
        else if (position == 4) {
            fragment = new Cosa_fragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_id, fragment).commit();
        }
        else if (position == 5) {
            fragment = new cowPox();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_id, fragment).commit();
        }
        else if (position == 6){
            fragment = new dhori();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_id,fragment).commit();
        }
        else if (position == 7){
            fragment = new dugbe();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_id,fragment).commit();
        }
        else if (position == 8){
            fragment = new hantaan();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_id,fragment).commit();
        }
        else if (position  == 9){
            fragment = new corona();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_id,fragment).commit();
        }

    }
}
