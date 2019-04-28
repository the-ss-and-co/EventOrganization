package com.Myproject.myapp.Activity;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.Myproject.myapp.R;
import com.Myproject.myapp.fragments.VenderLisingFragment;

public class VenderListingActivity extends AppCompatActivity implements View.OnClickListener {
    LinearLayout lin_near_me, lin_explore, lin_wish_list, lin_booking, lin_account;
    ImageView img_near_me, img_explore, img_wish_list, img_booking, img_account;
    TextView txt_near_me, txt_explore, txt_wish_list, txt_booking, txt_account;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_near:
                    // replace(new VenderLisingFragment());
                    return true;
                case R.id.navigation_explore:


                    return true;
                case R.id.navigation_wish:


                    return true;
                case R.id.navigation_booking:


                    return true;
                case R.id.navigation_acc:


                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vender_listing);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.listing_container, new VenderLisingFragment()).commit();
        BottomNavigationView navigationView = findViewById(R.id.bottom_nev);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //  initview();

        BottomNavigationMenuView menuView = (BottomNavigationMenuView) navigationView.getChildAt(0);
        for (int i = 0; i < menuView.getChildCount(); i++) {
            final View iconView = menuView.getChildAt(i).findViewById(android.support.design.R.id.icon);
            final ViewGroup.LayoutParams layoutParams = iconView.getLayoutParams();
            final DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 25, displayMetrics);
            layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 25, displayMetrics);
            iconView.setLayoutParams(layoutParams);
        }

    }

    private void initview() {
        lin_near_me = findViewById(R.id.lin_near_me);
        lin_explore = findViewById(R.id.lin_explore);
        lin_wish_list = findViewById(R.id.lin_wish_list);
        lin_booking = findViewById(R.id.lin_booking);
        lin_account = findViewById(R.id.lin_account);

        img_near_me = findViewById(R.id.img_near_me);
        img_explore = findViewById(R.id.img_explore);
        img_wish_list = findViewById(R.id.img_wish_list);
        img_booking = findViewById(R.id.img_booking);
        img_account = findViewById(R.id.img_account);

        txt_near_me = findViewById(R.id.txt_near_me);
        txt_explore = findViewById(R.id.txt_explore);
        txt_wish_list = findViewById(R.id.txt_wist_list);
        txt_booking = findViewById(R.id.txt_booking);
        txt_account = findViewById(R.id.txt_account);

    }

    private void replace(Fragment fragment) {
        String backStateName = fragment.getClass().getName();
        boolean fragmentPopped = getFragmentManager().popBackStackImmediate(backStateName, 0);

        if (!fragmentPopped) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.location_contaner, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();

        }
    }

    @Override
    public void onClick(View v) {

    }
}