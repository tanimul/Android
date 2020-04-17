package com.example.fuad.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
int []pic;
String []playername;
Context context;
private LayoutInflater inflater;
CustomAdapter(Context context,String[]playername,int[]pic){
    this.context=context;
    this.playername=playername;
    this.pic=pic;


}
    @Override
    public int getCount() {
        return playername.length;
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
        if(convertView == null){
           inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
          convertView=inflater.inflate(R.layout.sample_view,parent,false);
        }
        ImageView imageView=convertView.findViewById(R.id.imageview);
        TextView textView=convertView.findViewById(R.id.textview1);
        imageView.setImageResource(pic[position]);
        textView.setText(playername[position]);
        return convertView;
    }
}
