package com.Myproject.myapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.Myproject.myapp.Activity.VenderListingActivity;
import com.Myproject.myapp.R;

public class LocationAdress extends Fragment {
    ImageView backarrow;
    TextInputEditText Eventhouse,Areaname,City,Town,State,Pin,Landmark;
    Button save;
String city,state,pin,type="";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.locatin_adress,container,false);
        backarrow = view.findViewById(R.id.backarrow);
        Eventhouse = view.findViewById(R.id.eventhouse);
        Areaname = view.findViewById(R.id.areaname);
        City = view.findViewById(R.id.city);
        Town = view.findViewById(R.id.town);
        State = view.findViewById(R.id.state);
        Pin = view.findViewById(R.id.pin);
        Landmark = view.findViewById(R.id.landmark);
        save = view.findViewById(R.id.save);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        savedInstanceState=getArguments();
        if(savedInstanceState!=null){

city=savedInstanceState.getString("city");
state=savedInstanceState.getString("state");
pin=savedInstanceState.getString("postalCode");
if(savedInstanceState.containsKey("type")){
    type=savedInstanceState.getString("type");

}

City.setText(city);
State.setText(state);
Pin.setText(pin);

backarrow.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        replace(new GetLocationFragment(),type);
    }
});
save.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        try {
            if(type.equals("change")){
                getContext().startActivity(new Intent(getContext(), VenderListingActivity.class));
                getActivity().finish();
            }else
                replace(new DestinationAdress(),type);
        }catch (Exception e){
            replace(new DestinationAdress(),type);

        }
    }
});
        }
    }


    private void replace(Fragment fragment,String type) {
        String backStateName = fragment.getClass().getName();
        boolean fragmentPopped = getFragmentManager().popBackStackImmediate(backStateName,0);

        if (!fragmentPopped) {

            Bundle bundle=new Bundle();
            bundle.putString("type",type);
            fragment.setArguments(bundle);
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.location_contaner, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();

        }
    }
}
