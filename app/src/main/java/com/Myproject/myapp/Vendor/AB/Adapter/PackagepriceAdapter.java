package com.Myproject.myapp.Vendor.AB.Adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Myproject.myapp.R;
import com.Myproject.myapp.Vendor.AB.Model.PackagepriceModel;

import java.util.ArrayList;

public class PackagepriceAdapter extends RecyclerView.Adapter<PackagepriceAdapter.MyViewHolder> {
    ArrayList<PackagepriceModel> arrayList;
    Context context;

    public PackagepriceAdapter(ArrayList<PackagepriceModel> arrayList,Context context){
        this.arrayList=arrayList;
        this.context=context;
    }
    @NonNull
    @Override
    public PackagepriceAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.packagepriceitem,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PackagepriceAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.price_amount.setText(arrayList.get(i).getPrice_amount());
        myViewHolder.original_amount.setText(arrayList.get(i).getOriginal_amount());
        myViewHolder.discount_amount.setText(arrayList.get(i).getDiscount_amount());
        myViewHolder.original_amount.setPaintFlags(myViewHolder.original_amount.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView price_amount,original_amount,discount_amount;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            price_amount = itemView.findViewById(R.id.price_amount);
            original_amount = itemView.findViewById(R.id.original_price);
            discount_amount = itemView.findViewById(R.id.discount_amount);
        }
    }
}
