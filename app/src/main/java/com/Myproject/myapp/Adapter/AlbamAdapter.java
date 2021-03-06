package com.Myproject.myapp.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.Myproject.myapp.Model.pricemodel;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class AlbamAdapter extends RecyclerView.Adapter<AlbamAdapter.ViewHolder> {
    ArrayList<pricemodel> arrayList;

    public AlbamAdapter(ArrayList<pricemodel> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public AlbamAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.eventdetailslist,viewGroup,false);

        return new AlbamAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbamAdapter.ViewHolder viewHolder, int i) {
        viewHolder.checkbox.setText(arrayList.get(i).getName());
        viewHolder.txt_price.setText(arrayList.get(i).getPrice());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkbox;
        TextView txt_price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkbox=itemView.findViewById(R.id.checkbox);
            txt_price=itemView.findViewById(R.id.txt_price);
        }
    }
}

