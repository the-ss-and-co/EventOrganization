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
import android.widget.TextView;

import com.Myproject.myapp.Adapter.AddEquipmentAdapter;
import com.Myproject.myapp.Model.Equipmentmodel;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class RegistrationFrag2 extends Fragment {
    RecyclerView recycler_equipment;
    ArrayList<Equipmentmodel> arrayList;
    AddEquipmentAdapter addEquipmentAdapter;
    TextView add_more;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.registrationfrag2,container,false);
        recycler_equipment = view.findViewById(R.id.recycler_equipment);
        add_more = view.findViewById(R.id.add_more);

        arrayList = new ArrayList<>();
        arrayList.add(new Equipmentmodel("",""));

        add_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.add(new Equipmentmodel("",""));
            }
        });

        addEquipmentAdapter=new AddEquipmentAdapter(getContext(),arrayList);
        recycler_equipment.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recycler_equipment.setAdapter(addEquipmentAdapter);
        return view;
    }
}
