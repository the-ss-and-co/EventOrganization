package com.Myproject.myapp.Vendor.AB.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.Myproject.myapp.R;
import com.Myproject.myapp.Vendor.AB.Model.PackageItemModel;

import java.util.ArrayList;

public class PackageItemAdapter extends RecyclerView.Adapter<PackageItemAdapter.MyViewHolder> {
    ArrayList<PackageItemModel> arrayList;
    Context context;

    public PackageItemAdapter(Context context,ArrayList<PackageItemModel> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }
    @NonNull
    @Override
    public PackageItemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.packageitem,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PackageItemAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.textView.setText(arrayList.get(i).getItem());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item);
        }
    }
}
