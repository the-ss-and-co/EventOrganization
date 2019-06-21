package com.Myproject.myapp.Vendor.AB.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.Myproject.myapp.Adapter.AddEquipmentAdapter;
import com.Myproject.myapp.Model.Equipmentmodel;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class CeremonyListApepter extends RecyclerView.Adapter<CeremonyListApepter.ViewHolder> {
    ArrayList<Equipmentmodel> arrayList;
    Context context;
String  type;
    public CeremonyListApepter(ArrayList<Equipmentmodel> arrayList, Context context,String type) {
        this.arrayList = arrayList;
        this.context = context;
        this.type=type;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ceremonyitems,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
if(type.equalsIgnoreCase("others")){
    viewHolder.check_box.setVisibility(View.VISIBLE);
}
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox check_box;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            check_box=itemView.findViewById(R.id.mednatory_vheckbox);
        }
    }
}
