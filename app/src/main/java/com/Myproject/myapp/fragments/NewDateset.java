package com.Myproject.myapp.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.Myproject.myapp.Adapter.NewDateAdapter;
import com.Myproject.myapp.Model.NewDateModel;
import com.Myproject.myapp.R;
import java.util.ArrayList;


public class NewDateset extends Fragment  {
      ImageView Backpressed,Call;
      RecyclerView recyclerView;
      Button apply;
      ArrayList<NewDateModel> arrayList;
      NewDateAdapter dateAdapter;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.new_set_dates,container,false);
        Backpressed = view.findViewById(R.id.back_press);
        Call = view.findViewById(R.id.call);
        recyclerView = view.findViewById(R.id.item_date);
        apply =view.findViewById(R.id.apply);

        arrayList = new ArrayList<>();
        arrayList.add(new NewDateModel("item1",""));
        arrayList.add(new NewDateModel("item1",""));
        arrayList.add(new NewDateModel("item1",""));


        dateAdapter = new NewDateAdapter(arrayList,getContext());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(dateAdapter);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Backpressed.setOnClickListener(v ->{
            replace(new PackageDetailsFragment(),"no");
        });
        apply.setOnClickListener(v->{
            replace(new PackageDetailsFragment(),"yes");
        });
    }

    private void replace(Fragment fragment,String type){
        String backStateName = fragment.getClass().getName();
        Bundle bundle = null;
      //  boolean fragmentPopped = getFragmentManager().popBackStackImmediate(backStateName, 0);
        if(type.equals("yes")) {
             bundle = new Bundle();
            bundle.putString("setdate","setdate");
            fragment.setArguments(bundle);

        }


       // if (!fragmentPopped){
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.container_vender_details, fragment);
            ft.addToBackStack(null);
            ft.commit();
       // }
    }

}
