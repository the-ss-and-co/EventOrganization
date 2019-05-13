package com.Myproject.myapp.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.Myproject.myapp.R;
import com.Myproject.myapp.fragments.GetLocationFragment;

public class Location extends AppCompatActivity{
String type="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        savedInstanceState=getIntent().getExtras();
        if(savedInstanceState!=null){
          type=savedInstanceState.getString("type");
        } else {
            type="no";
        }
        replace(new GetLocationFragment(),type);
    }

    private void replace(Fragment fragment,String type) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
 Bundle bundle=new Bundle();
 bundle.putString("type",type);
 fragment.setArguments(bundle);
            ft.replace(R.id.location_contaner, fragment);
            ft.commit();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }
}
