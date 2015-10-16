package com.example.pankaj.browsefile;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TabPagerAdapter extends FragmentStatePagerAdapter {
    int noOfTab;

    public TabPagerAdapter(FragmentManager fm, int noOfTab) {
        super(fm);
        this.noOfTab = noOfTab;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FragmentFirst firstTAb = new FragmentFirst();
                return firstTAb;
            case 1:
                FragmentSecond secondTab = new FragmentSecond();
                return secondTab;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return noOfTab;
    }
}
