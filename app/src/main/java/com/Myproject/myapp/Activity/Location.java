package com.Myproject.myapp.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.Myproject.myapp.R;
import com.Myproject.myapp.fragments.GetLocationFragment;

public class Location extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        replace(new GetLocationFragment());
    }

    private void replace(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

            ft.replace(R.id.location_contaner, fragment);
            ft.commit();


    }


    @Override
    protected void onResume() {
        super.onResume();
            replace(new GetLocationFragment());
    }
}
