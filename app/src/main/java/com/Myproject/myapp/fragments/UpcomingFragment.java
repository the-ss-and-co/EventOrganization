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

import com.Myproject.myapp.Adapter.DateAdapter_upcoming;
import com.Myproject.myapp.Adapter.UpcomingBookingAdaper;
import com.Myproject.myapp.Model.Date_Model;
import com.Myproject.myapp.Model.UpcomingModel;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class UpcomingFragment extends Fragment {
    RecyclerView recycler_date,recycler_upcminglist;
    ArrayList<Date_Model>arrayList;
    ArrayList<UpcomingModel>upcomingModelArrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.upcoing_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        iniview(view);
    }

    private void iniview(View view) {
        recycler_date=view.findViewById(R.id.recycler_date);
        recycler_upcminglist=view.findViewById(R.id.recycler_upcminglist);


        arrayList=new ArrayList<>();
        upcomingModelArrayList=new ArrayList<>();

        addlistdata(upcomingModelArrayList);
        adddata(arrayList);

        DateAdapter_upcoming adapter=new DateAdapter_upcoming(arrayList,getContext());
        recycler_date.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        recycler_date.setAdapter(adapter);

        UpcomingBookingAdaper bookingAdaper=new UpcomingBookingAdaper(upcomingModelArrayList,getContext());
        recycler_upcminglist.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
recycler_upcminglist.setAdapter(bookingAdaper);

    }

    private void addlistdata(ArrayList<UpcomingModel> upcomingModelArrayList) {
        upcomingModelArrayList.add(new UpcomingModel("FEstive Calender","Photographer",
                "Merrage","20000","5000","****"));
        upcomingModelArrayList.add(new UpcomingModel("FEstive Calender","Photographer",
                "Merrage","20000","5000","****"));
    }

    private void adddata(ArrayList<Date_Model> arrayList) {
        Date_Model dateModel=new Date_Model();
        dateModel.setDay("22");
        dateModel.setMonth("MAR");
        dateModel.setYear("2019");
        Date_Model dateModel1=new Date_Model();
        dateModel1.setDay("02");
        dateModel1.setMonth("APR");
        dateModel1.setYear("2019");
        Date_Model dateModel2=new Date_Model();
        dateModel2.setDay("28");
        dateModel2.setMonth("FEB");
        dateModel2.setYear("2020");
        Date_Model dateModel3=new Date_Model();
        dateModel3.setDay("28");
        dateModel3.setMonth("FEB");
        dateModel3.setYear("2019");

        arrayList.add(dateModel);
        arrayList.add(dateModel1);
        arrayList.add(dateModel2);
        arrayList.add(dateModel3);

    }
}
