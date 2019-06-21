package com.Myproject.myapp.Vendor.AB.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Myproject.myapp.R;
import com.Myproject.myapp.Vendor.AB.Adapter.PackageItemAdapter;
import com.Myproject.myapp.Vendor.AB.Adapter.PackagepriceAdapter;
import com.Myproject.myapp.Vendor.AB.Model.PackageItemModel;
import com.Myproject.myapp.Vendor.AB.Model.PackagepriceModel;

import java.util.ArrayList;

public class PackagesFragment extends Fragment {
    ArrayList<PackageItemModel> arrayList;
    ArrayList<PackagepriceModel> pricearrayList;
    PackageItemAdapter packageItemAdapter;
    PackagepriceAdapter packagepriceAdapter;
    RecyclerView packageItem,starting_price;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.packagesfrag,container,false);
        packageItem = view.findViewById(R.id.packages_recyler);
        starting_price = view.findViewById(R.id.starting_price);

        arrayList = new ArrayList<>();
        arrayList.add(new PackageItemModel("Marriage"));
        arrayList.add(new PackageItemModel("Birthday"));
        arrayList.add(new PackageItemModel("Funeral"));
        arrayList.add(new PackageItemModel("Anniversary"));
        arrayList.add(new PackageItemModel("Corporate"));
        arrayList.add(new PackageItemModel("Party"));

        pricearrayList = new ArrayList<>();
        pricearrayList.add(new PackagepriceModel("16000","20000","10%"));
        pricearrayList.add(new PackagepriceModel("16000","20000","10%"));
        pricearrayList.add(new PackagepriceModel("16000","20000","10%"));

        packageItemAdapter = new PackageItemAdapter(getContext(),arrayList);
        packageItem.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        packageItem.setAdapter(packageItemAdapter);

        packagepriceAdapter = new PackagepriceAdapter(pricearrayList,getContext());
        starting_price.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        starting_price.setAdapter(packagepriceAdapter);


        return view;
    }
}
