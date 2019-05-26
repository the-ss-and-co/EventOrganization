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

import com.Myproject.myapp.Adapter.BillsItemAdapter;
import com.Myproject.myapp.Model.BillsItem;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class Bills extends Fragment {
    RecyclerView bills_item;
    BillsItemAdapter billsItemAdapter;
    ArrayList<BillsItem> arrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bills_data,container,false);

        arrayList = new ArrayList<>();
        bills_item = view.findViewById(R.id.bills_item);

        arrayList.add(new BillsItem("Vendor Name","Booked For 5 Days","Funeral","50,000"));
        arrayList.add(new BillsItem("Vendor Name","Booked For 5 Days","Corporate Meeting","50,000"));
        arrayList.add(new BillsItem("Vendor Name","Booked For 5 Days","Marriage","50,000"));
        arrayList.add(new BillsItem("Vendor Name","Booked For 5 Days","BirthDay","50,000"));

        billsItemAdapter = new BillsItemAdapter(getContext(),arrayList);
        bills_item.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        bills_item.setAdapter(billsItemAdapter);


        return  view;
    }
}
