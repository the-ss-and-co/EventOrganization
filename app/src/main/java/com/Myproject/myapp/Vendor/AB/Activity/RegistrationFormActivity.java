package com.Myproject.myapp.Vendor.AB.Activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.Myproject.myapp.R;
import com.Myproject.myapp.Vendor.AB.Fragment.RegistrationFrag1;
import com.Myproject.myapp.fragments.VenderDetailsFragment;

public class RegistrationFormActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.registration_from_container,new RegistrationFrag1()).commit();
    }
}
