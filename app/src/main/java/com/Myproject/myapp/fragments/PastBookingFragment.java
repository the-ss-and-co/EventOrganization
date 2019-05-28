package com.Myproject.myapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Myproject.myapp.Adapter.PastBokingAdapter;
import com.Myproject.myapp.Model.PastDataModel;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class PastBookingFragment extends Fragment {
    RecyclerView festive_calender;
    ArrayList<PastDataModel> arrayList ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.pastbooking_fragment,container,false);
        festive_calender = view.findViewById(R.id.festive_calender);

        arrayList = new ArrayList<>();
        arrayList.add(new PastDataModel("Festive Calender","26 JAN 2018","Marriage","Event House"));
        arrayList.add(new PastDataModel("Festive Calender","26 JAN 2018","Marriage","Event House"));
        arrayList.add(new PastDataModel("Festive Calender","26 JAN 2018","Marriage","Event House"));


        PastBokingAdapter bookingAdaper=new PastBokingAdapter(getContext(),arrayList);
        festive_calender.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        festive_calender.setAdapter(bookingAdaper);
        return  view;
    }
}
