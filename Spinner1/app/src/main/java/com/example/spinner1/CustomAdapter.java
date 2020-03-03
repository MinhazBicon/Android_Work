package com.example.spinner1;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    private String[] item_name;
    private String[] descripton;
    private int[] image;
    Context context;
    private LayoutInflater layoutInflater;

    public CustomAdapter(Context context,int[] image, String[] item_name, String[] descripton) {
            this.item_name = item_name;
        this.descripton = descripton;
        this.image = image;
        this.context = context;
    }

    public int getCount()
    {
        return image.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {
         LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         convertView =layoutInflater.inflate(R.layout.spinner_layout,parent,false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageview_id);
        imageView.setImageResource(image[position]);

        TextView item = convertView.findViewById(R.id.textview_id2);
        item.setText(item_name[position]);

        TextView decription = convertView.findViewById(R.id.textview_id3);
        decription.setText(descripton[position]);
        return convertView;

    }


}
