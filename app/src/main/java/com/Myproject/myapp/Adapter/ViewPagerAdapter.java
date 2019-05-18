package com.Myproject.myapp.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.Myproject.myapp.fragments.PastBookingFragment;
import com.Myproject.myapp.fragments.UpcomingFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    int num_of_tab;

    public ViewPagerAdapter(FragmentManager fm,int count) {
        super(fm);
        this.num_of_tab=count;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                UpcomingFragment upcomingFragment=new UpcomingFragment();
                return upcomingFragment;
            case 1:
                PastBookingFragment pastBookingFragment=new PastBookingFragment();
                return pastBookingFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return num_of_tab;
    }
}
