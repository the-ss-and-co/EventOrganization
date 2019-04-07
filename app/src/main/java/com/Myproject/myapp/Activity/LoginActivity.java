package com.Myproject.myapp.Activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.Myproject.myapp.R;
import com.Myproject.myapp.fragments.LoginFragment;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
            replaceFrament();
         }

    private void replaceFrament(){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.login_continer,new LoginFragment()).commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        replaceFrament();
    }
}
