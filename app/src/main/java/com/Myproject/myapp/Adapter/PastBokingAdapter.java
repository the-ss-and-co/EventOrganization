package com.Myproject.myapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Myproject.myapp.Model.PastDataModel;
import com.Myproject.myapp.R;

import java.util.ArrayList;


public class PastBokingAdapter extends RecyclerView.Adapter<PastBokingAdapter.PastViewHolder> {
    Context context;
    ArrayList<PastDataModel> arrayList;

    public  PastBokingAdapter(Context context, ArrayList<PastDataModel> arrayList){
        this.arrayList = arrayList;
        this.context=context;
    }
    @NonNull
    @Override
    public PastBokingAdapter.PastViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.past_boking_item,viewGroup,false);
        return new PastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PastBokingAdapter.PastViewHolder pastViewHolder, int i) {
        pastViewHolder.festive_calender.setText(arrayList.get(i).getFestive_calender());
        pastViewHolder.date.setText(arrayList.get(i).getDate());
        pastViewHolder.event_house.setText(arrayList.get(i).getEvent_name());
        pastViewHolder.event_type.setText(arrayList.get(i).getEvent_type());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class PastViewHolder extends RecyclerView.ViewHolder {
        TextView festive_calender,date,event_type,event_house;
        public PastViewHolder(@NonNull View itemView) {
            super(itemView);
            festive_calender= itemView.findViewById(R.id.festive_calender);
            date= itemView.findViewById(R.id.date_festive);
            event_house=itemView.findViewById(R.id.event_house);
            event_type=itemView.findViewById(R.id.event_type);
        }
    }
}
