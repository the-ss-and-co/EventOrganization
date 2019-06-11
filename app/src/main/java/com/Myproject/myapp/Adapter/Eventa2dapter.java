package com.Myproject.myapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.Myproject.myapp.Model.EventModel;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class Eventa2dapter extends RecyclerView.Adapter<Eventa2dapter.ViewHolder> {
    ArrayList<EventModel> arrayList;
    Context context;
    int i=0;

    public Eventa2dapter(ArrayList<EventModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.eventlist,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        if(arrayList.get(i).isIsval()){
            viewHolder.r1.setBackgroundColor(context.getResources().getColor(R.color.green));
            viewHolder.r2.setBackgroundColor(context.getResources().getColor(R.color.light_green));
        }else {
            viewHolder.r1.setBackgroundColor(context.getResources().getColor(R.color.unchacked));
            viewHolder.r2.setBackgroundColor(context.getResources().getColor(R.color.light_black));
        }
        viewHolder.txt_event_name.setText(arrayList.get(i).getEventText());
viewHolder.rel_event.setOnClickListener(v -> {
    this.i=i;
    notifyDataSetChanged();
});
if(this.i==i){
    viewHolder.r1.setBackgroundColor(context.getResources().getColor(R.color.green));
    viewHolder.r2.setBackgroundColor(context.getResources().getColor(R.color.light_green));
}else {
    viewHolder.r1.setBackgroundColor(context.getResources().getColor(R.color.unchacked));
    viewHolder.r2.setBackgroundColor(context.getResources().getColor(R.color.light_black));
}
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout r1,r2,rel_event;
        TextView txt_event_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            r1=itemView.findViewById(R.id.r1);
            r2=itemView.findViewById(R.id.r2);
            txt_event_name=itemView.findViewById(R.id.txt_event_name);
            rel_event=itemView.findViewById(R.id.rel_event);


        }
    }
}
