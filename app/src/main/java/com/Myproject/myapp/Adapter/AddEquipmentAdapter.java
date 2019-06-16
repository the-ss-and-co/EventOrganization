package com.Myproject.myapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.Myproject.myapp.Model.Equipmentmodel;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class AddEquipmentAdapter extends RecyclerView.Adapter<AddEquipmentAdapter.MyviewHolder> {
    Context context;
    ArrayList<Equipmentmodel> arrayList;
    public AddEquipmentAdapter(Context context, ArrayList<Equipmentmodel> arrayList){
        this.context = context;
        this.arrayList = arrayList;

    }
    @NonNull
    @Override
    public AddEquipmentAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.equipment_item,viewGroup,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddEquipmentAdapter.MyviewHolder myviewHolder, int i) {


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        LinearLayout equipment_layout;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            equipment_layout = itemView.findViewById(R.id.edt_equipment);
        }
    }
}
