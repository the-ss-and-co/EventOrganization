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

import com.Myproject.myapp.Adapter.PackageListAdapter;
import com.Myproject.myapp.Model.pricemodel;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class PackageList extends Fragment implements PackageListAdapter.ClickListener {
    RecyclerView package_list;
ArrayList<pricemodel>arrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.packagelist,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        package_list=view.findViewById(R.id.package_list);
        arrayList=new ArrayList<>();
        adddata();
        PackageListAdapter adapter=new PackageListAdapter(arrayList,getContext());
        adapter.onarrowclick(this);
        package_list.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
package_list.setAdapter(adapter);
    }

    private void adddata() {
        pricemodel pricemodel=new pricemodel();
        pricemodel.setPrice("20000");
        arrayList.add(pricemodel);
        pricemodel pricemodel1=new pricemodel();
        pricemodel1.setPrice("20500");
        arrayList.add(pricemodel1);
        pricemodel pricemodel2=new pricemodel();
        pricemodel2.setPrice("10000");
        arrayList.add(pricemodel2);
    }

    @Override
    public void onarrowclick(int id) {
replace(new PackageDetailsFragment());
    }
    private void replace(Fragment fragment){
        String backStateName = fragment.getClass().getName();
        boolean fragmentPopped = getFragmentManager().popBackStackImmediate(backStateName, 0);

        if (!fragmentPopped){
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.container_vender_details, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }
}
