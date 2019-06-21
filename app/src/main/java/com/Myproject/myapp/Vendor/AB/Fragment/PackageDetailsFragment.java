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

import com.Myproject.myapp.Model.Equipmentmodel;
import com.Myproject.myapp.R;
import com.Myproject.myapp.Vendor.AB.Adapter.CeremonyListApepter;

import java.util.ArrayList;

public class PackageDetailsFragment extends Fragment {
RecyclerView ceremony_list,album_list,others_list;
CeremonyListApepter ceremonyListApepter,albumadapter,othersadapter;
    ArrayList<Equipmentmodel> aryceremony,albumary;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.venderpackagedetails,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initview(view);
        initobrect();
    }

    private void initobrect() {
        aryceremony=new ArrayList<>();
        albumary=new ArrayList<>();

        aryceremony.add(new Equipmentmodel("",""));
        aryceremony.add(new Equipmentmodel("",""));
        albumary.add(new Equipmentmodel("",""));
        albumary.add(new Equipmentmodel("",""));


ceremonyListApepter=new CeremonyListApepter(aryceremony,getContext(),"ceremony");
ceremony_list.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
ceremony_list.setAdapter(ceremonyListApepter);

        albumadapter=new CeremonyListApepter(aryceremony,getContext(),"album");
        album_list.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        album_list.setAdapter(albumadapter);


        othersadapter=new CeremonyListApepter(aryceremony,getContext(),"others");
        others_list.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
others_list.setAdapter(othersadapter);

    }

    private void initview(View view) {
        ceremony_list=view.findViewById(R.id.ceremony_list);
        album_list=view.findViewById(R.id.album_list);
        others_list=view.findViewById(R.id.others_list);


    }
}
