package com.example.expandable_listview;

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
    List<String> list_data_header;
    HashMap<String,List<String>> list_data_child;

    public CustomAdapter(Context context, List<String> list_data_header, HashMap<String, List<String>> list_data_child) {
        this.context = context;
        this.list_data_header = list_data_header;
        this.list_data_child = list_data_child;
    }

    @Override
    public int getGroupCount() {
        return list_data_header.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return list_data_child.get(list_data_header.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return list_data_header.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return list_data_child.get(list_data_header.get(groupPosition)).get(childPosition);
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
        String header_text = (String) getGroup(groupPosition);
        if (convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView  = layoutInflater.inflate(R.layout.group_layout,null);
        }
        TextView textView =  convertView.findViewById(R.id.header_textview);
        textView.setText(header_text);
        return convertView;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String child_text = (String) getChild(groupPosition,childPosition);
        if (convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         convertView = layoutInflater.inflate(R.layout.child_layout,null);
        }
        TextView textView = convertView.findViewById(R.id.child_textview);
        textView.setText(child_text);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition)
    {
        return true;
    }
}
