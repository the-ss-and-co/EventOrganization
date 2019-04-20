package com.Myproject.myapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.Myproject.myapp.R;

public class LocationAdress2 extends Fragment {
    TextInputEditText Eventhouse,Landmark;
    TextView Locationtext;
    ImageView Backarrow;
    Button Skip,save;
String address;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.location_adress2,container,false);
        Eventhouse = view.findViewById(R.id.hoseno);
        Landmark = view.findViewById(R.id.land);
        Locationtext = view.findViewById(R.id.locationtext);
        Backarrow = view.findViewById(R.id.backarrow);
        Skip = view.findViewById(R.id.skip);
        save = view.findViewById(R.id.save);
        return  view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        savedInstanceState=getArguments();
        if(savedInstanceState!=null){
            address=savedInstanceState.getString("address");
            Locationtext.setText(address);
        }
<
        Backarrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replace(new GetLocationFragment());
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replace(new DestinationAdress());
            }
        });

    }

    private void replace(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        boolean fragmentPopped = getFragmentManager().popBackStackImmediate(backStateName,0);

        if (!fragmentPopped) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.location_contaner,fragment);
            ft.addToBackStack(backStateName);
            ft.commit();

        }

    }
}
