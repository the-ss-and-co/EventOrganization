package com.Myproject.myapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.Myproject.myapp.Model.PriceItem;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class ItemPriceAdapter extends RecyclerView.Adapter<ItemPriceAdapter.PriceViewHolder> {
    Context context;
    ArrayList<PriceItem> arrayList;
    public ItemPriceAdapter(Context context,ArrayList<PriceItem> arrayList){
        this.context = context;
        this.arrayList = arrayList;


    }
    @NonNull
    @Override
    public ItemPriceAdapter.PriceViewHolder  onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_price,viewGroup,false);
        return new PriceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemPriceAdapter.PriceViewHolder  viewHolder, int i) {
        viewHolder.price_item.setText(arrayList.get(i).getItem_name());
        viewHolder.price_per_item.setText(arrayList.get(i).getPrice());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class PriceViewHolder extends RecyclerView.ViewHolder {
        TextView price_item,price_per_item;
        PriceViewHolder(@NonNull View itemView) {
            super(itemView);
            price_item = itemView.findViewById(R.id.price_item);
            price_per_item = itemView.findViewById(R.id.price_per_item);
        }
    }
}
