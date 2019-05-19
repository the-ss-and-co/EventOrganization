package com.Myproject.myapp.Adapter;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.Myproject.myapp.Model.NewDateModel;
import com.Myproject.myapp.R;

import java.util.ArrayList;
import java.util.Calendar;

public class NewDateAdapter extends RecyclerView.Adapter<NewDateAdapter.ViewHolder> implements DatePickerDialog.OnDateSetListener {
    ArrayList<NewDateModel> arrayList;
    Context context;
     String dateon;


    public NewDateAdapter(ArrayList<NewDateModel> arrayList, Context context){
        this.arrayList=arrayList;
        this.context=context;

    }
    @NonNull
    @Override
    public NewDateAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.date_item,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.date.setText(arrayList.get(i).getDate());
        viewHolder.item.setText(arrayList.get(i).getItem());
        viewHolder.calender.setOnClickListener(v -> {
            Showdatepicker();
        });

    }

    private void Showdatepicker() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(context,this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
         dateon = " "+month+"/"+dayOfMonth+"/"+year;


    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView item,date;
        ImageView calender;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.item);
            date = itemView.findViewById(R.id.date);
            calender =itemView.findViewById(R.id.calender);

        }
    }
}
