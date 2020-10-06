package com.example.task2.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.task2.R;
import com.example.task2.data.PagerAdapters;
import com.google.android.material.tabs.TabLayout;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PagerAdapters homeTabsViewPagerAdapter = new PagerAdapters(getSupportFragmentManager(),
                PagerAdapters.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,this);
        ViewPager viewPager = findViewById(R.id.activity_home_pager);
        viewPager.setAdapter(homeTabsViewPagerAdapter);
        TabLayout tabLayout = findViewById(R.id.activity_home_tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
    }
