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

import com.Myproject.myapp.Adapter.Service4Adapter;
import com.Myproject.myapp.Model.Service4item;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class Service4 extends Fragment {
    RecyclerView recyclerView_item;
    Service4Adapter service4Adapter;
    ArrayList<Service4item> arrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.service_4,container,false);
        recyclerView_item = view.findViewById(R.id.recycle_item);

        arrayList = new ArrayList<>();
        arrayList.add(new Service4item("item1","Jan 26 2019","17,999"));
        arrayList.add(new Service4item("item2","Jan 26 2019","17,999"));
        arrayList.add(new Service4item("item3","Jan 26 2019","17,999"));

        service4Adapter =new Service4Adapter(getContext(),arrayList);
        recyclerView_item.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView_item.setAdapter(service4Adapter);

        return view;
    }
}
