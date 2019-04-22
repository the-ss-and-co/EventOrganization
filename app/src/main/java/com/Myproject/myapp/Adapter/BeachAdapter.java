package com.Myproject.myapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.Myproject.myapp.Model.Modelbeachitem;
import com.Myproject.myapp.Model.NewAddedlistModel;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class BeachAdapter extends RecyclerView.Adapter<BeachAdapter.ViewHolder> {
    ArrayList<Modelbeachitem> arrayList;
    Context context;

    public BeachAdapter(ArrayList<Modelbeachitem> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public BeachAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.vender_beachiteam, viewGroup, false);
        return new BeachAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BeachAdapter.ViewHolder viewHolder, int i) {
        viewHolder.wishlist_no.setText(arrayList.get(i).getWishlist_no());
        viewHolder.title_name.setText(arrayList.get(i).getTitle_name());
        viewHolder.amount.setText(arrayList.get(i).getAmount());
        viewHolder.extra_charge.setText(arrayList.get(i).getExtra_charge());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView wishlist_no,title_name,extra_charge,amount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            wishlist_no = itemView.findViewById(R.id.wishlist_no);
            title_name = itemView.findViewById(R.id.title_name);
            extra_charge = itemView.findViewById(R.id.extra_charge);
            amount = itemView.findViewById(R.id.amount);



        }
    }
}
