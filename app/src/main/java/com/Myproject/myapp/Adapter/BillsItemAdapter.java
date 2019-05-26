package com.Myproject.myapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.Myproject.myapp.Model.BillsItem;
import com.Myproject.myapp.R;
import com.Myproject.myapp.fragments.Service4;

import java.util.ArrayList;

public class BillsItemAdapter extends RecyclerView.Adapter<BillsItemAdapter.ViewHolder> {
    Context context;
    ArrayList<BillsItem> arrayList;

    public  BillsItemAdapter(Context context, ArrayList<BillsItem> arrayList){
        this.context = context;
        this.arrayList = arrayList;

    }
    @NonNull
    @Override
    public BillsItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bills_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BillsItemAdapter.ViewHolder viewHolder, int i) {
        viewHolder.vendor_name.setText(arrayList.get(i).getVendarname());
        viewHolder.event.setText(arrayList.get(i).getEvent_type());
        viewHolder.amount.setText(arrayList.get(i).getAmount());
        viewHolder.booking_days.setText(arrayList.get(i).getBoking_time());

        viewHolder.item_view.setOnClickListener(v -> {
           replace(new Service4());
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView vendor_name,booking_days,event,amount,book_again;
        RelativeLayout item_view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_view = itemView.findViewById(R.id.item_view);
            vendor_name = itemView.findViewById(R.id.vendor_name);
            booking_days = itemView.findViewById(R.id.booked_days);
            event = itemView.findViewById(R.id.event_t);
            amount = itemView.findViewById(R.id.amount);
            book_again = itemView.findViewById(R.id.book_again);
        }
    }
    private void replace(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        boolean fragmentPopped = ((FragmentActivity)context).getSupportFragmentManager().popBackStackImmediate(backStateName, 0);
        FragmentManager fm = ((FragmentActivity)context).getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (!fragmentPopped) {
            ft.replace(R.id.account_contaner, fragment);
            ft.addToBackStack(null);
            ft.commit();
        }
    }
}
