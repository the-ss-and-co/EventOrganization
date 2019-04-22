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

import com.Myproject.myapp.Adapter.NewAddedAdapter;
import com.Myproject.myapp.Model.NewAddedlistModel;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class VenderLisingFragment extends Fragment {
RecyclerView recycler_new_add;
ArrayList<NewAddedlistModel>arrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vender_listing,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initview(view);
    }

    private void initview(View view){
        recycler_new_add =view.findViewById(R.id.recycler_new_add);
        arrayList=new ArrayList<>();
    alldata(arrayList);

        NewAddedAdapter adapter=new NewAddedAdapter(arrayList,getContext());
        recycler_new_add.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
recycler_new_add.setAdapter(adapter);
    }

    private void alldata(ArrayList<NewAddedlistModel> arrayList) {
        NewAddedlistModel model=new NewAddedlistModel();
        model.setName("Eimon Farhad");
        model.setAddress("Sukanta nagar,Sector 4,pin-700098");
        model.setCount("20");
        arrayList.add(model);
        NewAddedlistModel model1=new NewAddedlistModel();
        model1.setName("Eimon Farhad");
        model1.setAddress("Sukanta nagar,Sector 4,pin-700098");
        model1.setCount("20");
        arrayList.add(model1);
    }
}
