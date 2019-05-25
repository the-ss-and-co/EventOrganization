package com.Myproject.myapp.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.Myproject.myapp.R;
import com.Myproject.myapp.fragments.CancelbookingFragment;
import com.Myproject.myapp.fragments.UpcomingDetailsFragment;

public class UpcomingdetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_booking);
        savedInstanceState=getIntent().getExtras();
        if(savedInstanceState!=null){
            if(savedInstanceState.containsKey("cancel")){
                replace(new CancelbookingFragment());
            }
            if(savedInstanceState.containsKey("details")){
                replace(new UpcomingDetailsFragment());
            }
        }
    }
    private void replace(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.contaner_upcoming, fragment);
            ft.commit();
        }
}
