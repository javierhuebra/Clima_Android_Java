package com.example.teclabapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> ciudades;

    public CustomAdapter(Context context, ArrayList<String> ciudades){
        this.context = context;
        this.ciudades = ciudades;
    }

    @Override
    public int getCount() {
        return this.ciudades.size();
    }

    @Override
    public Object getItem(int position) {
        return this.ciudades.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        view = layoutInflater.inflate(R.layout.list_item_ciudad, null);
        String currentName = ciudades.get(position);
        TextView textView = (TextView) view.findViewById(R.id.textview_item);
        textView.setText(currentName);

        return view;
    }
}
