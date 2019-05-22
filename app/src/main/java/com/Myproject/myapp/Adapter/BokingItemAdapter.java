package com.Myproject.myapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Myproject.myapp.Model.BokingItem;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class BokingItemAdapter extends RecyclerView.Adapter<BokingItemAdapter.BokingViewholder> {
    Context context;
    ArrayList<BokingItem> arrayList;

    public  BokingItemAdapter(Context context, ArrayList<BokingItem> arrayList){
        this.context = context;
        this.arrayList = arrayList;

    }

    @NonNull
    @Override
    public BokingItemAdapter.BokingViewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.boking_details_item,viewGroup,false);
         return new BokingViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BokingItemAdapter.BokingViewholder bokingViewholder, int i) {
        bokingViewholder.item.setText(arrayList.get(i).getItem());
        bokingViewholder.day.setText(arrayList.get(i).getDay());
        bokingViewholder.date_of_day.setText(arrayList.get(i).getDay_of_daate());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class BokingViewholder extends RecyclerView.ViewHolder {
        TextView item,day,date_of_day;
        public BokingViewholder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.item1);
            day = itemView.findViewById(R.id.day);
            date_of_day = itemView.findViewById(R.id.day_of_date);
        }
    }
}
