package com.Myproject.myapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Myproject.myapp.Model.EventTag;
import com.Myproject.myapp.R;

import java.util.ArrayList;


public class EventViewAdapter extends RecyclerView.Adapter<EventViewAdapter.MyViewHolder> {
    ArrayList<EventTag> arrayList = new ArrayList<>();
    Context context;
    public EventViewAdapter(ArrayList<EventTag> arrayList, Context context){
        this.arrayList=arrayList;
        this.context=context;

    }
    @NonNull
    @Override
    public EventViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_view,viewGroup,false);
        return new EventViewAdapter.MyViewHolder(view);    }

    @Override
    public void onBindViewHolder(@NonNull EventViewAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.event_text.setText(arrayList.get(i).getEvent());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView event_text;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            event_text =itemView.findViewById(R.id.text_event);
        }
    }
}
