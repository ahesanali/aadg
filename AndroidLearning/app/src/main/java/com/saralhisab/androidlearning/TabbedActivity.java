package com.saralhisab.androidlearning;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class TabbedActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        //step-1 setup toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //step-2 setup tabs FragmentViewPageAdapter
        ViewPager viewPager = (ViewPager) findViewById(R.id.tabs_view_pager);
        // Assign created adapter to viewPager
        viewPager.setAdapter(new TabsDemoPageAdapter(getSupportFragmentManager()));

        //step-3 setup FragmentViewPageAdapter for tabs widgets
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        // This method setup all required method for TabLayout with Viewpager
        tabLayout.setupWithViewPager(viewPager);


    }

    public static class TabsDemoPageAdapter extends FragmentPagerAdapter{

        public TabsDemoPageAdapter(FragmentManager fm) {
            super(fm);
        }

        // This overridden method of FragmentPageAdapter will give proper tab's content fragment
        // based on tab index selection
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                      return  new TabOneFragment();
                case 1:
                    return  new TabTwoFragment();
                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            /**
             *   as we know there are two fixed tabs so we return 2 directly,
             *   but in practical scenario you have to pass data structure's length
             *   most probably Array List length
             */

            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return  "Home";
                case 1:
                    return  "News";
                default:
                    return null;
            }
        }
    }

}
