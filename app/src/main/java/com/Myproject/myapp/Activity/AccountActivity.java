package com.Myproject.myapp.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.Myproject.myapp.R;
import com.Myproject.myapp.fragments.Bills;
import com.Myproject.myapp.fragments.GenerateReferalCode_Fragment;
import com.Myproject.myapp.fragments.Help;
import com.Myproject.myapp.fragments.PrivacyPolicy;

public class AccountActivity extends AppCompatActivity {
    FrameLayout frameLayout;
String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        savedInstanceState=getIntent().getExtras();
        if(savedInstanceState!=null){
        type=savedInstanceState.getString("type");
        }

        if(type.equalsIgnoreCase("bill")){
            replaceFragment(new Bills());
        }else if(type.equalsIgnoreCase("help")){
            replaceFragment(new Help());
        }else if(type.equalsIgnoreCase("policy")){
            replaceFragment(new PrivacyPolicy());
        }else if(type.equalsIgnoreCase("code")){
replaceFragment(new GenerateReferalCode_Fragment());
        }

    }

    private void replaceFragment( Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.account_contaner,fragment).commit();
    }
}
