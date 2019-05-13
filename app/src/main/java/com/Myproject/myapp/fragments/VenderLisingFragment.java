package com.Myproject.myapp.fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.RelativeLayout;

import android.widget.ImageButton;
import android.widget.TextView;


import com.Myproject.myapp.Activity.Location;
import com.Myproject.myapp.Adapter.BeachAdapter;
import com.Myproject.myapp.Adapter.NewAddedAdapter;
import com.Myproject.myapp.Model.Modelbeachitem;
import com.Myproject.myapp.Model.NewAddedlistModel;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class VenderLisingFragment extends Fragment implements View.OnClickListener {
    RecyclerView recycler_new_add, beach_item;
    ImageView filter;

    RelativeLayout change_event,rel_change_add;

    RelativeLayout rel_change_event;
    ArrayList<NewAddedlistModel> arrayList;
    ArrayList<Modelbeachitem> arrayList2;
    TextView service_name;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vender_listing, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initview(view);
    }

    private void initview(View view) {
        recycler_new_add = view.findViewById(R.id.recycler_new_add);
        filter = view.findViewById(R.id.filter);
        rel_change_event = view.findViewById(R.id.rel_change_event);
//        change_service = view.findViewById(R.id.change_service);
        service_name = view.findViewById(R.id.service_name);
        rel_change_add=view.findViewById(R.id.rel_change_add);
        beach_item = view.findViewById(R.id.beachimg_item);
        change_event = view.findViewById(R.id.rel_change_event);

        arrayList = new ArrayList<>();
        alldata(arrayList);
        arrayList2 = new ArrayList<>();
        alldatabeach(arrayList2);

        NewAddedAdapter adapter = new NewAddedAdapter(arrayList, getContext());
        recycler_new_add.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recycler_new_add.setAdapter(adapter);
        service_name.setOnClickListener(this);
        rel_change_event.setOnClickListener(this);
        rel_change_add.setOnClickListener(this);
        filter.setOnClickListener(this);


        recycler_new_add.setAdapter(adapter);
        BeachAdapter beachAdapter = new BeachAdapter(arrayList2, getContext());
        beach_item.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        beach_item.setAdapter(beachAdapter);
    }

    private void alldatabeach(ArrayList<Modelbeachitem> arrayList2) {
        Modelbeachitem modelbeachitem = new Modelbeachitem();
        modelbeachitem.setWishlist_no("1123 people wishtedlisted");
        modelbeachitem.setTitle_name("Panama Beach Coral Avenue");
        modelbeachitem.setAmount("$49");
        modelbeachitem.setExtra_charge("Starting From");
        arrayList2.add(modelbeachitem);
    }

    private void alldata(ArrayList<NewAddedlistModel> arrayList) {
        NewAddedlistModel model = new NewAddedlistModel();
        model.setName("Eimon Farhad");
        model.setAddress("Sukanta nagar,Sector 4,pin-700098");
        model.setCount("20");
        arrayList.add(model);
        NewAddedlistModel model1 = new NewAddedlistModel();
        model1.setName("Eimon Farhad");
        model1.setAddress("Sukanta nagar,Sector 4,pin-700098");
        model1.setCount("20");
        arrayList.add(model1);
    }

    private void replace(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        boolean fragmentPopped = getFragmentManager().popBackStackImmediate(backStateName, 0);

        if (!fragmentPopped) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.listing_container, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.filter:
                replace(new PriceRating());

                break;
            case R.id.rel_change_event:
                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.dialog_box);
                dialog.show();
                break;
            case R.id.service_name:
                opendialog();
                break;
            case R.id.rel_change_add:
                Intent intent=new Intent(getContext(), Location.class);
                intent.putExtra("type","change");
                startActivity(intent);
                getActivity().finish();
        }
    }

    private void opendialog() {
        Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.filter);
        dialog.show();

    }
}