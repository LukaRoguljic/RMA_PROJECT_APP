package com.example.csgorganizer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    Context context;
    ArrayList<ListItem> arrayList;
    public MyAdapter(Context context, ArrayList<ListItem> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.mycustomlistview, null);

            TextView idLV       = (TextView)convertView.findViewById(R.id.idLV);
            TextView opponentLV = (TextView)convertView.findViewById(R.id.opponentLV);
            TextView mapsLV     = (TextView)convertView.findViewById(R.id.mapsLV);
            TextView dateLV     = (TextView)convertView.findViewById(R.id.dateLV);
            TextView commentLV  = (TextView)convertView.findViewById(R.id.commentLV);

            ListItem listItem = arrayList.get(position);

            idLV.setText(String.valueOf(listItem.getId()));
            opponentLV.setText(listItem.getOpponent());
            mapsLV.setText(listItem.getMaps());
            dateLV.setText(listItem.getDate());
            commentLV.setText(listItem.getComment());



        return convertView;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }


}
