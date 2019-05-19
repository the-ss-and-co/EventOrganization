package com.Myproject.myapp.fragments;

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
import android.widget.Button;

import com.Myproject.myapp.Adapter.AlbamAdapter;
import com.Myproject.myapp.Adapter.Equipmentlistapapter;
import com.Myproject.myapp.Adapter.EventDetails;
import com.Myproject.myapp.Model.pricemodel;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class PackageDetailsFragment extends Fragment {
    RecyclerView recycler_event_details,recycler_equipment_details,recycler_Albums_details;
    ArrayList<pricemodel>eventarrayList;
    ArrayList<pricemodel>equipmentarraylist;
    ArrayList<pricemodel>albamarraylist;
    Button Set_Date;


    @Nullable
    @Override
     public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
          return inflater.inflate(R.layout.packagedetailsfragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initview(view);

        adddata(eventarrayList);
        adddata1(equipmentarraylist);
        addalbam(albamarraylist);
        EventDetails eventDetails=new EventDetails(eventarrayList);
        recycler_event_details.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recycler_event_details.setAdapter(eventDetails);

        Equipmentlistapapter equipmentlistapapter=new Equipmentlistapapter(equipmentarraylist);
        recycler_equipment_details.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recycler_equipment_details.setAdapter(equipmentlistapapter);

        AlbamAdapter albamAdapter=new AlbamAdapter(albamarraylist);
        recycler_Albums_details.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recycler_Albums_details.setAdapter(albamAdapter);

    }

    private void adddata1(ArrayList<pricemodel> equipmentarraylist) {
        pricemodel pricemodel=new pricemodel() ;
        pricemodel pricemodel1=new pricemodel() ;
        pricemodel pricemodel2=new pricemodel() ;

        pricemodel.setPrice("2000");
        pricemodel1.setPrice("5000");
        pricemodel2.setPrice("4100");
        pricemodel.setName("Equipment 1");
        pricemodel2.setName("Equipment 2");
        pricemodel1.setName("Equipment 3");

        equipmentarraylist.add(pricemodel);
        equipmentarraylist.add(pricemodel1);
        equipmentarraylist.add(pricemodel2);
    }

    private void initview(View view) {
        recycler_event_details=view.findViewById(R.id.recycler_event_details);
        recycler_equipment_details=view.findViewById(R.id.recycler_equipment_details);
        recycler_Albums_details=view.findViewById(R.id.recycler_Albums_details);
        Set_Date = view.findViewById(R.id.set_date);

        Set_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               replace(new SetDate());
            }
        });

        eventarrayList=new ArrayList<>();
        equipmentarraylist=new ArrayList<>();
        albamarraylist=new ArrayList<>();

    }

    private void adddata(ArrayList<pricemodel> arrayList) {
        pricemodel pricemodel=new pricemodel() ;
        pricemodel pricemodel1=new pricemodel() ;
        pricemodel pricemodel2=new pricemodel() ;

        pricemodel.setPrice("2000");
        pricemodel1.setPrice("5000");
        pricemodel2.setPrice("4100");
        pricemodel.setName("Pre Wedding");
        pricemodel2.setName("Mid Wedding");
        pricemodel1.setName("After Wedding");

        arrayList.add(pricemodel);
        arrayList.add(pricemodel1);
        arrayList.add(pricemodel2);
    }
 public void addalbam(ArrayList<pricemodel> arrayList){
     pricemodel pricemodel=new pricemodel() ;
     pricemodel pricemodel1=new pricemodel() ;
     pricemodel pricemodel2=new pricemodel() ;

     pricemodel.setPrice("2000");
     pricemodel1.setPrice("5000");
     pricemodel2.setPrice("4100");
     pricemodel.setName("Albam 1");
     pricemodel2.setName("Albam 2");
     pricemodel1.setName("Albam 3");

     arrayList.add(pricemodel);
     arrayList.add(pricemodel1);
     arrayList.add(pricemodel2);
 }
    private void replace(Fragment fragment){
        String backStateName = fragment.getClass().getName();
        boolean fragmentPopped = getFragmentManager().popBackStackImmediate(backStateName,0);

        if (!fragmentPopped) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.container_vender_details,fragment);
            ft.addToBackStack(backStateName);
            ft.commit();

        }

    }
}
