package com.Myproject.myapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.Myproject.myapp.Model.Modelbeachitem;
import com.Myproject.myapp.Model.pricemodel;
import com.Myproject.myapp.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class PackageListAdapter extends RecyclerView.Adapter<PackageListAdapter.ViewHolder> {
ArrayList<pricemodel>arrayList;
Context context;
ClickListener listener;

    public PackageListAdapter(ArrayList<pricemodel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.packaagelistitem,viewGroup,false);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.price.setText(arrayList.get(i).getPrice());
        viewHolder.right_arrow.setOnClickListener(v -> {
listener.onarrowclick(arrayList.get(i).getId());
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView price;
        RelativeLayout right_arrow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            right_arrow=itemView.findViewById(R.id.right_arrow);
            price=itemView.findViewById(R.id.price);
        }
    }

    public  interface ClickListener{
        void onarrowclick(int id);
    }
    public void onarrowclick(ClickListener listener){
this.listener=listener;
    }

}
