package com.Myproject.myapp.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Myproject.myapp.Adapter.BokingItemAdapter;
import com.Myproject.myapp.Adapter.ItemPriceAdapter;
import com.Myproject.myapp.Model.BokingItem;
import com.Myproject.myapp.Model.PriceItem;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class UpcomingDetailsFragment extends Fragment {
    RecyclerView booking_item_date,price_recycler;
    TextView secret_code_txt;

    ArrayList<PriceItem> PricearrayList;
    ArrayList<BokingItem> ItemarrayList;

    BokingItemAdapter bokingItemAdapter;
    ItemPriceAdapter itemPriceAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.upcomingdetails_frag,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initview(view);
        initObject();



        ItemarrayList.add(new BokingItem("item1","Wednusday","26 Jan 2018"));
        ItemarrayList.add(new BokingItem("item2","Wednusday","26 Jan 2018"));
        ItemarrayList.add(new BokingItem("item3","Wednusday","26 Jan 2018"));
        ItemarrayList.add(new BokingItem("item4","Wednusday","26 Jan 2018"));

        PricearrayList.add(new PriceItem("Item1","17,000"));
        PricearrayList.add(new PriceItem("Item2","17,000"));
        PricearrayList.add(new PriceItem("Item3","17,000"));
        bokingItemAdapter=new BokingItemAdapter(getContext(),ItemarrayList);
        booking_item_date.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        booking_item_date.setAdapter(bokingItemAdapter);

        itemPriceAdapter=new ItemPriceAdapter(getContext(),PricearrayList);
        price_recycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        price_recycler.setAdapter(itemPriceAdapter);
    }

    private void initview(View view) {
        booking_item_date=view.findViewById(R.id.booking_item_date);
        price_recycler=view.findViewById(R.id.price_recycler);
        secret_code_txt=view.findViewById(R.id.secret_code_txt);
    }
    private void initObject() {
        ItemarrayList = new ArrayList<>();
        PricearrayList = new ArrayList<>();
        SpannableStringBuilder builder = new SpannableStringBuilder();
        SpannableString str1= new SpannableString("Below a ");
        str1.setSpan(new ForegroundColorSpan(Color.BLACK), 0, str1.length(), 0);
        builder.append(str1);

        SpannableString str2= new SpannableString("Secter Code");
        str2.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.red)), 0, str2.length(), 0);
        str2.setSpan(new RelativeSizeSpan(1.2f), 0,str2.length(), 0); // set size
        builder.append(str2);

        SpannableString str3= new SpannableString(" is provided.verify the vendor using this code. this code will appear at the starting day of service");
        str3.setSpan(new ForegroundColorSpan(Color.BLACK), 0, str1.length(), 0);
        builder.append(str3);

        secret_code_txt.setText( builder, TextView.BufferType.SPANNABLE);

    }
}
