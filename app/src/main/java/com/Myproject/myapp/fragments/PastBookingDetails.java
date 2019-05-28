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

import com.Myproject.myapp.Adapter.BokingItemAdapter;
import com.Myproject.myapp.Adapter.ItemPriceAdapter;
import com.Myproject.myapp.Model.BokingItem;
import com.Myproject.myapp.Model.PriceItem;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class PastBookingDetails extends Fragment {
    RecyclerView ItemRecycleview,PriceRecylerView;

    BokingItemAdapter bokingItemAdapter;
    ItemPriceAdapter itemPriceAdapter;

    ArrayList<PriceItem> PricearrayList;
    ArrayList<BokingItem> ItemarrayList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.bokingdetails,container,false);

        ItemRecycleview = view.findViewById(R.id.item_recycler);
        PriceRecylerView = view.findViewById(R.id.price_recycler);

        ItemarrayList = new ArrayList<>();
        PricearrayList = new ArrayList<>();

        ItemarrayList.add(new BokingItem("item1","Wednusday","26 Jan 2018"));
        ItemarrayList.add(new BokingItem("item2","Wednusday","26 Jan 2018"));
        ItemarrayList.add(new BokingItem("item3","Wednusday","26 Jan 2018"));
        ItemarrayList.add(new BokingItem("item4","Wednusday","26 Jan 2018"));

        PricearrayList.add(new PriceItem("Item1","17,000"));
        PricearrayList.add(new PriceItem("Item2","17,000"));
        PricearrayList.add(new PriceItem("Item3","17,000"));


        bokingItemAdapter=new BokingItemAdapter(getContext(),ItemarrayList);
        ItemRecycleview.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        ItemRecycleview.setAdapter(bokingItemAdapter);

        itemPriceAdapter=new ItemPriceAdapter(getContext(),PricearrayList);
        PriceRecylerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        PriceRecylerView.setAdapter(itemPriceAdapter);

        return view;
    }
}
