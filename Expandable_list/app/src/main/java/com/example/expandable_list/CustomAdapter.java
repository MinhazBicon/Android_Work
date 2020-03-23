package com.example.expandable_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class CustomAdapter extends BaseExpandableListAdapter {
    private Context context;
    List<String> head_data_list;
    HashMap<String,List<String>> child_data_list;

    public CustomAdapter(Context context, List<String> head_data_list, HashMap<String, List<String>> child_data_list) {
        this.context = context;
        this.head_data_list = head_data_list;
        this.child_data_list = child_data_list;
    }

    @Override
    public int getGroupCount() {
        return head_data_list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return child_data_list.get(head_data_list.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return head_data_list.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return child_data_list.get(head_data_list.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String head_text = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           convertView = layoutInflater.inflate(R.layout.head_layout, null);
        }
            TextView textView = convertView.findViewById(R.id.headtext_id);
            textView.setText(head_text);
            return convertView;
        }


        @Override
        public View getChildView ( int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent){
           String child_text = (String) getChild(groupPosition,childPosition);
           if (convertView == null){
               LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
              convertView = layoutInflater.inflate(R.layout.child_layout,null);
           }
           TextView textView = convertView.findViewById(R.id.childtext_id);
           textView.setText(child_text);
            return convertView;
        }

        @Override
        public boolean isChildSelectable ( int groupPosition, int childPosition){
            return true;
        }

    }