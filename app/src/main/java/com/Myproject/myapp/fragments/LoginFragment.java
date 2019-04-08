package com.Myproject.myapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.Myproject.myapp.Activity.ServiceActivity;
import com.Myproject.myapp.R;

public class LoginFragment extends Fragment {
    Button btn_next;
    EditText edt_phone,edt_name;
    TextInputLayout edt_phone_main,edt_name_main;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmentlogin,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initviews(view);
 btn_next.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         replaceFrgment();
     }
 });
    }

    private void replaceFrgment() {
//        FragmentManager fm=getFragmentManager();
//        FragmentTransaction ft=fm.beginTransaction();
//        ft.replace(R.id.login_continer,new OtpFragment()).commit();
        startActivity(new Intent(getContext(), ServiceActivity.class));
        getActivity().finish();
    }

    private void initviews(View view) {
        btn_next=view.findViewById(R.id.btn_next);
        edt_phone=view.findViewById(R.id.edt_phone);
        edt_name=view.findViewById(R.id.edt_name);
        edt_phone_main=view.findViewById(R.id.edt_phone_main);
        edt_name_main=view.findViewById(R.id.edt_name_main);
    }
}
