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
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.Myproject.myapp.Model.PastDataModel;
import com.Myproject.myapp.R;
import com.Myproject.myapp.fragments.PastBookingDetails;

import java.util.ArrayList;


public class PastBokingAdapter extends RecyclerView.Adapter<PastBokingAdapter.PastViewHolder> {
    Context context;
    ArrayList<PastDataModel> arrayList;

    public  PastBokingAdapter(Context context, ArrayList<PastDataModel> arrayList){
        this.arrayList = arrayList;
        this.context=context;
    }
    @NonNull
    @Override
    public PastBokingAdapter.PastViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.past_boking_item,viewGroup,false);
        return new PastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PastBokingAdapter.PastViewHolder pastViewHolder, int i) {
        pastViewHolder.festive_calender.setText(arrayList.get(i).getFestive_calender());
        pastViewHolder.date.setText(arrayList.get(i).getDate());
        pastViewHolder.event_house.setText(arrayList.get(i).getEvent_name());
        pastViewHolder.event_type.setText(arrayList.get(i).getEvent_type());
        if(i==1){
         pastViewHolder.rel_due_pay.setVisibility(View.GONE);
         pastViewHolder.vv.setVisibility(View.GONE);
         pastViewHolder.rating.setVisibility(View.GONE);
         pastViewHolder.txtnow.setVisibility(View.VISIBLE);
        }else {
            pastViewHolder.paid.setVisibility(View.GONE);
        }
        pastViewHolder.goto_boking_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replace(new PastBookingDetails());
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class PastViewHolder extends RecyclerView.ViewHolder {
        TextView festive_calender,date,event_type,event_house,paid,txtnow;
        RelativeLayout goto_boking_details,rel_due_pay;
        RatingBar rating;
        View vv;
        public PastViewHolder(@NonNull View itemView) {
            super(itemView);
            vv=itemView.findViewById(R.id.vv);
            rating=itemView.findViewById(R.id.rating);
            txtnow=itemView.findViewById(R.id.txtnow);
            festive_calender= itemView.findViewById(R.id.festive_calender);
            date= itemView.findViewById(R.id.date_festive);
            event_house=itemView.findViewById(R.id.event_house);
            event_type=itemView.findViewById(R.id.event_type);
            paid=itemView.findViewById(R.id.paid);
            rel_due_pay=itemView.findViewById(R.id.rel_due_pay);
            goto_boking_details = itemView.findViewById(R.id.goto_bokingdetails);
        }
    }


    private void replace(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        boolean fragmentPopped = ((FragmentActivity)context).getSupportFragmentManager().popBackStackImmediate(backStateName, 0);
        FragmentManager fm = ((FragmentActivity)context).getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (!fragmentPopped) {
            ft.replace(R.id.listing_container, fragment);
            ft.addToBackStack(null);
            ft.commit();
        }
    }
}
