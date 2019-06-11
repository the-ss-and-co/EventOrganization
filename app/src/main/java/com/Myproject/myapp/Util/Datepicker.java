package com.Myproject.myapp.Util;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.TextView;


import com.Myproject.myapp.R;

import java.util.Calendar;


@SuppressLint("ValidFragment")
public class Datepicker extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    String string_Date;
ondateselectListener listener;
TextView textView;

    public Datepicker(TextView date) {
      textView=date;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState){


        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog dialog = new DatePickerDialog(getActivity(),
                this, year, month, day);

        dialog.getDatePicker().setMinDate(c.getTime().getTime());
        c.add(Calendar.DATE,30);
        return dialog;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day){

        String years = "" + year;
        String months = "" + (month + 1);
        String days = "" + day;


        if (month >= 0 && month < 9) {
            months = "0" + (month + 1);
        }

        if (day > 0 && day < 10) {
            days = "0" + day;
        }

        string_Date = years + "/" + months + "/" + days;
        textView.setText(string_Date);
//        TextView date_set = getActivity().findViewById(R.id.date);
//date_set.setText(string_Date);
       // listener.ondateset(string_Date);
    }
   public interface ondateselectListener{
        void ondateset(String date);
    }
    public  void ondateset(ondateselectListener listener){
      this.listener=listener;
    }
}