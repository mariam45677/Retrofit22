package com.example.task2.data;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.task2.R;
import com.example.task2.fragment.FavouriteFragment;
import com.example.task2.fragment.HomeFragment;

public class PagerAdapters extends FragmentPagerAdapter {
    private static final int[] Res =
            new int[]{R.string.home, R.string.favourite};
    private Context context;


    public PagerAdapters (@NonNull FragmentManager fm, int behavior,Context context) {
        super(fm, behavior);
        this.context=context;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0 :
                fragment = HomeFragment.newInstance();
                break;
            case 1 :
                fragment = FavouriteFragment.newInstance();
                break;
        }
        return fragment;
    }
    // TODO 1: add this to show the tabs text ( you can change the tabs colors using this
//  app:tabTextColor="#ffffff" in XML file in TabLayout ).

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return context.getResources().getString(Res[position]);
    }



    @Override
    public int getCount() {
            return Res.length;
        }

}
