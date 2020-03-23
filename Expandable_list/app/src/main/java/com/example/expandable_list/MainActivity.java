package com.example.expandable_list;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {
    private ExpandableListView expandableListView;
    List<String> head_data_list;
    HashMap<String,List<String>> child_data_list;
    private int last_collapse_position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = findViewById(R.id.expandablelist_id);
        data_for_expandable_list();

        CustomAdapter customadapter = new CustomAdapter(this,head_data_list,child_data_list);
        expandableListView.setAdapter(customadapter);

        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                String group_value = head_data_list.get(groupPosition);
                Toast.makeText(getApplicationContext(),group_value,Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String child_value = child_data_list.get(head_data_list.get(groupPosition)).get(childPosition);
                Toast.makeText(getApplicationContext(),child_value,Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                String head_group  = head_data_list.get(groupPosition);
                Toast.makeText(getApplicationContext(),head_group,Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                if (last_collapse_position != -1 && last_collapse_position != groupPosition){
                    expandableListView.collapseGroup(last_collapse_position);
                }
                last_collapse_position = groupPosition;
            }
        });


    }

    public void data_for_expandable_list() {
        String[] head_data = getResources().getStringArray(R.array.headName);
        String[] child_data = getResources().getStringArray(R.array.childName);

        head_data_list = new ArrayList<String>();
        child_data_list = new HashMap<String, List<String>>();

        for (int i = 0; i < head_data.length; i++) {

            head_data_list.add(head_data[i]);
            List<String> child = new ArrayList<String>();
            child.add(child_data[i]);
            child_data_list.put(head_data_list.get(i), child);


        }

    }
}
