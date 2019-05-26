package com.Myproject.myapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Myproject.myapp.Model.Service4item;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class Service4Adapter extends RecyclerView.Adapter<Service4Adapter.ViewHolder> {
    Context context;
    ArrayList<Service4item> arrayList;

    public Service4Adapter(Context context, ArrayList<Service4item> arrayList){
        this.arrayList = arrayList;
        this.context = context;

    }
    @NonNull
    @Override
    public Service4Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.service4item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Service4Adapter.ViewHolder viewHolder, int i) {
        viewHolder.item.setText(arrayList.get(i).getItem());
        viewHolder.date.setText(arrayList.get(i).getDate());
        viewHolder.amount.setText(arrayList.get(i).getAmount());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView item,date,amount;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.item);
            date = itemView.findViewById(R.id.date);
            amount = itemView.findViewById(R.id.single_amount);
        }
    }
}
