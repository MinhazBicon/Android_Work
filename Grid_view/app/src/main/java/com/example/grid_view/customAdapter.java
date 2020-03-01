package com.example.grid_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class customAdapter extends BaseAdapter {
    Context context;
    int[] flag;
    String[] countryname;
    private LayoutInflater layoutInflater;

    customAdapter(Context context, String[] countryname, int[]flag){
        this.context = context;
        this.countryname = countryname;
        this.flag = flag;

    }
    public int getCount() {
        return countryname.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.gridlayout,parent,false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageview_id);
        TextView textView = convertView.findViewById(R.id.textview_id);
        imageView.setImageResource(flag[position]);
        textView.setText(countryname[position]);

        return convertView;
    }
}
