package com.Myproject.myapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.Myproject.myapp.Model.EventTag;
import com.Myproject.myapp.R;

import java.util.ArrayList;


public class EventViewAdapter extends RecyclerView.Adapter<EventViewAdapter.MyViewHolder> {
    ArrayList<EventTag> arrayList = new ArrayList<>();
    Context context;
    int row_index;
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
        myViewHolder.back_rel.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                row_index=i;
                notifyDataSetChanged();
            }
        });
        if(row_index==i){
            myViewHolder.back_rel.setBackgroundResource(R.drawable.edittext_back_round);
            myViewHolder.event_text.setTextColor(Color.parseColor("#ffffff"));
        }
        else
        {
            myViewHolder.back_rel.setBackgroundResource(R.drawable.blank_back);
            myViewHolder.event_text.setTextColor(Color.parseColor("#000000"));
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView event_text;
        RelativeLayout back_rel;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            event_text =itemView.findViewById(R.id.text_event);
            back_rel =itemView.findViewById(R.id.rel_back);
        }
    }
}
