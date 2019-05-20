package com.Myproject.myapp.Adapter;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.Myproject.myapp.Model.NewDateModel;
import com.Myproject.myapp.R;
import com.Myproject.myapp.Util.Datepicker;

import java.util.ArrayList;
import java.util.Calendar;

import static com.Myproject.myapp.R.layout.date_item;

public class NewDateAdapter extends RecyclerView.Adapter<NewDateAdapter.ViewHolder>  implements Datepicker.ondateselectListener{
    ArrayList<NewDateModel> arrayList;
    Context context;


    public NewDateAdapter(ArrayList<NewDateModel> arrayList, Context context){
        this.arrayList=arrayList;
        this.context=context;

    }
    @NonNull
    @Override
    public NewDateAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(date_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.date.setText(arrayList.get(i).getDate());
        viewHolder.item.setText(arrayList.get(i).getItem());

        viewHolder.calender.setOnClickListener(v -> {
            DialogFragment fragment=new Datepicker(viewHolder.date);
           // ((Datepicker) fragment).ondateset(this);
            fragment.show(((AppCompatActivity)context).getSupportFragmentManager(),"DatePick");
        });

    }



    @Override
    public int getItemCount() {
        return arrayList.size();

    }

    @Override
    public void ondateset(String date) {
                TextView date_set = ((Activity)context).findViewById(R.id.date);
                date_set.setText(date);


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
