package com.Myproject.myapp.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.Myproject.myapp.R;

public class Account extends Fragment {
    TextView bills,profile,be_our_partner,help,privacy_policy;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.account,container,false);

        bills = view.findViewById(R.id.bills);
        profile = view.findViewById(R.id.profile);
        be_our_partner = view.findViewById(R.id.partner);
        help = view.findViewById(R.id.help);
        privacy_policy = view.findViewById(R.id.privacy_policy);

        bills.setOnClickListener(v -> replace(new Bills()));
        help.setOnClickListener(v -> replace(new Help()));
        privacy_policy.setOnClickListener(v -> replace(new PrivacyPolicy()));
        return  view;
    }

    private void replace(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        assert getFragmentManager() != null;
        boolean fragmentPopped = getFragmentManager().popBackStackImmediate(backStateName, 0);

        if (!fragmentPopped) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.listing_container, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();

        }
    }
}
