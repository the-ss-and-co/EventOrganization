package com.Myproject.myapp.Adapter;

import android.content.Context;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.Myproject.myapp.Model.EventModel;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyviewHolder> {
    Context context;
    ArrayList<EventModel> arrayList;

    public  EventAdapter(Context context,ArrayList<EventModel> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public EventAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.eventitem,viewGroup,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventAdapter.MyviewHolder myviewHolder, int i) {
        myviewHolder.textView.setText(arrayList.get(i).getEventText());
        myviewHolder.imageView.setImageResource(arrayList.get(i).getImage());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.eventtext);
            imageView = itemView.findViewById(R.id.eventicon);

        }
    }
}
