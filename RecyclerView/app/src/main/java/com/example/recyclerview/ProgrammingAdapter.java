package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ProgrammingAdapter extends RecyclerView.Adapter<ProgrammingAdapter.Programviewholder>{
    public ProgrammingAdapter(String[] data) {
        this.data = data;
    }
    private String[]data;
    public ImageView imageView1;

    public Programviewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

       LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
       View view=inflater.inflate(R.layout.list_item_layout,viewGroup,false);
        return new Programviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Programviewholder programviewholder, int i) {
        String title=data[i];
        programviewholder.textView.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class Programviewholder extends RecyclerView.ViewHolder{
            ImageView imageView;
            TextView textView;

        public Programviewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
            textView=itemView.findViewById(R.id.textView);
            imageView1=itemView.findViewById(R.id.imageview);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }


}
