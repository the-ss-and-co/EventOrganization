package com.Myproject.myapp.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.Myproject.myapp.Model.DateModel;
import com.Myproject.myapp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.ViewHolder> {
ArrayList<DateModel>arrayList;
Context context;
int item;


    public DateAdapter(ArrayList<DateModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(context).inflate(R.layout.dateitem,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.txt_day.setText(arrayList.get(i).getDay());
        viewHolder.txt_month.setText(arrayList.get(i).getMonth());
        viewHolder.txt_year.setText(arrayList.get(i).getYear());
        viewHolder.rel_date.setOnClickListener(v -> {
item=i;
notifyDataSetChanged();
        });
if(item==i){
    viewHolder.rel_date.setBackgroundColor(context.getResources().getColor(R.color.light_white));
}else {
    viewHolder.rel_date.setBackgroundColor(context.getResources().getColor(R.color.white));

}
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_day,txt_year,txt_month;
        RelativeLayout rel_date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_day=   itemView.findViewById(R.id.txt_day);
            txt_year=   itemView.findViewById(R.id.txt_year);
            txt_month=   itemView.findViewById(R.id.txt_month);
            rel_date=itemView.findViewById(R.id.rel_date);

        }
    }
}
