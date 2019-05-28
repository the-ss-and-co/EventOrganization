package com.Myproject.myapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.Myproject.myapp.Activity.VenderListingActivity;
import com.Myproject.myapp.Adapter.Eventa2dapter;
import com.Myproject.myapp.Model.EventModel;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class VenderDetailsFragment extends Fragment implements View.OnClickListener {
    TextView txt_distance,txt_extra;
    RecyclerView recycler_event;
    ArrayList<EventModel>arrayList;
    ImageView img_back;
    RelativeLayout image_rel;


Button btn_explore_package;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.venderdetails,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initview(view);
    }

    private void initview(View view) {
        img_back=view.findViewById(R.id.img_back);
        image_rel = view.findViewById(R.id.r2);
        txt_distance=view.findViewById(R.id.txt_distance);
        txt_extra=view.findViewById(R.id.txt_extra);
        recycler_event=view.findViewById(R.id.recycler_event);
        btn_explore_package=view.findViewById(R.id.btn_explore_package);

        btn_explore_package.setOnClickListener(this);
        img_back.setOnClickListener(this);

        arrayList=new ArrayList<>();
adddata(arrayList);



        String s="Destance Between  destinitation and  vender is above ";
        String next = "<font color='#000'>30KM</font>";
       String e= "Vender Charge extra on disdance above ";
       txt_extra.setText(Html.fromHtml(e+next));
        txt_distance.setText(Html.fromHtml(s+next));
        Eventa2dapter dapter=new Eventa2dapter(arrayList,getContext());
        recycler_event.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recycler_event.setAdapter(dapter);
        img_back.setOnClickListener(v -> {
         startActivity(new Intent(getContext(), VenderListingActivity.class));
          });
        image_rel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replace(new WorkShopGallery());
            }
        });
recycler_event.setAdapter(dapter);


    }

    private void adddata(ArrayList<EventModel> arrayList) {
        arrayList.add(new EventModel("Marriage",0,true));
        arrayList.add(new EventModel("Birthday",0,false));
        arrayList.add(new EventModel("Funeral",0,false));
        arrayList.add(new EventModel("Funeral",0,false));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back:
                startActivity(new Intent(getContext(), VenderListingActivity.class));
                getActivity().finish();
                break;
            case R.id.btn_explore_package :
              replace(new PackageList());
        break;
        }
    }



    private void replace(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        assert getFragmentManager() != null;
        boolean fragmentPopped = getFragmentManager().popBackStackImmediate(backStateName, 0);

        if (!fragmentPopped) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.container_vender_details, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();

        }
    }
}
