package com.example.custom_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    int[] flag;
    String[] CountryName;
    Context context;
    private LayoutInflater inflater;

    CustomAdapter(Context context,String[] CountryName, int[] flag){
        this.context = context;
        this.CountryName = CountryName;
        this.flag = flag;
    }

    public int getCount() {

        return CountryName.length;
    }

    @Override
    public Object getItem(int position){

        return null;
    }

    @Override
    public long getItemId(int position) {

        return  position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null ){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          convertView = inflater.inflate(R.layout.country_layout,parent,false);

        }

        ImageView imageView = convertView.findViewById(R.id.image_view_id);
        TextView textView = convertView.findViewById(R.id.text_view_id1);

        imageView.setImageResource(flag[position]);
        textView.setText(CountryName[position]);

        return convertView;

    }
}
