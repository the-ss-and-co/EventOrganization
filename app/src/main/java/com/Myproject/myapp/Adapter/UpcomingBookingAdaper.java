package com.Myproject.myapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.Myproject.myapp.Model.UpcomingModel;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class UpcomingBookingAdaper extends RecyclerView.Adapter<UpcomingBookingAdaper.ViewHolder> {
    ArrayList<UpcomingModel>arrayList;
Context context;

    public UpcomingBookingAdaper(ArrayList<UpcomingModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
View  view= LayoutInflater.from(context).inflate(R.layout.upcominglist,viewGroup,false);
return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
viewHolder.vender_name.setText(arrayList.get(i).getName());
viewHolder.event_name.setText(arrayList.get(i).getEvent_name());
viewHolder.service_name.setText(arrayList.get(i).getService_name());
viewHolder.due_pay.setText(arrayList.get(i).getDue_pay());
viewHolder.total_pay.setText(arrayList.get(i).getTotal_pay());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView vender_name,service_name,event_name,total_pay,due_pay;
        RelativeLayout rel_due_pay,rel_call;
        Button cancel;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            vender_name=itemView.findViewById(R.id.vender_name);
            service_name=itemView.findViewById(R.id.service_name);
            event_name=itemView.findViewById(R.id.event_name);
            total_pay=itemView.findViewById(R.id.total_pay);
            due_pay=itemView.findViewById(R.id.due_pay);
            rel_due_pay=itemView.findViewById(R.id.rel_due_pay);
            rel_call=itemView.findViewById(R.id.rel_call);
            cancel=itemView.findViewById(R.id.cancel);
        }
    }
}
