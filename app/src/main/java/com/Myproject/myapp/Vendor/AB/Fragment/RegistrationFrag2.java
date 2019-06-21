package com.Myproject.myapp.Vendor.AB.Fragment;

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
import android.widget.TextView;

import com.Myproject.myapp.Adapter.AddEquipmentAdapter;
import com.Myproject.myapp.Adapter.CoverEventAdapter;
import com.Myproject.myapp.Model.Equipmentmodel;
import com.Myproject.myapp.Model.EventcoverModel;
import com.Myproject.myapp.R;

import java.util.ArrayList;

public class RegistrationFrag2 extends Fragment {
    RecyclerView recycler_equipment, cover_event_recycler;
    ArrayList<Equipmentmodel> arrayList;
    ArrayList<EventcoverModel> arrayList2;
    AddEquipmentAdapter addEquipmentAdapter;
    CoverEventAdapter coverEventAdapter;
    TextView add_more;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.registrationfrag2, container, false);
        recycler_equipment = view.findViewById(R.id.recycler_equipment);
        add_more = view.findViewById(R.id.add_more);
        cover_event_recycler = view.findViewById(R.id.cover_event_recyler);

        arrayList = new ArrayList<>();
        arrayList.add(new Equipmentmodel("", ""));
        arrayList2 = new ArrayList<>();

        arrayList2.add(new EventcoverModel("Marriage"));
        arrayList2.add(new EventcoverModel("Anniversary"));
        arrayList2.add(new EventcoverModel("Birthday"));
        arrayList2.add(new EventcoverModel("Funeral"));
        arrayList2.add(new EventcoverModel("Corporate"));
        arrayList2.add(new EventcoverModel("Marriage"));

        view.findViewById(R.id.next).setOnClickListener(v -> {

        });
        add_more.setOnClickListener(v -> replace(new RegistrationFrag3()));
        add_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        view.findViewById(R.id.next).setOnClickListener(v -> {
            replace(new RegistrationFrag3());

        });


        addEquipmentAdapter = new AddEquipmentAdapter(getContext(), arrayList);
        recycler_equipment.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recycler_equipment.setAdapter(addEquipmentAdapter);

        coverEventAdapter = new CoverEventAdapter(arrayList2, getContext());
        cover_event_recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        cover_event_recycler.setAdapter(coverEventAdapter);
        return view;
    }


    private void replace(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        assert getFragmentManager() != null;
        boolean fragmentPopped = getFragmentManager().popBackStackImmediate(backStateName, 0);

        if (!fragmentPopped) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.registraton_form_contaner, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();


        }
    }
}