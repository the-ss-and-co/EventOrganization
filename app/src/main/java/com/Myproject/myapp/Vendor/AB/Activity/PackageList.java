package com.Myproject.myapp.Vendor.AB.Activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.Myproject.myapp.R;
import com.Myproject.myapp.Vendor.AB.Fragment.PackagesFragment;


public class PackageList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_list);
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.packageItem,new PackagesFragment()).commit();
    }
}
