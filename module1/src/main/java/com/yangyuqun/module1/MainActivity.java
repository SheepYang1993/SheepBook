package com.yangyuqun.module1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ViewPager vpContent;
    private FragmentPagerAdapter adapter;
    private TabLayout tlHead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        tlHead = findViewById(R.id.tlHead);
        vpContent = findViewById(R.id.vpContent);
        adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        vpContent.setAdapter(adapter);
        tlHead.setupWithViewPager(vpContent);
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return Module1TabFragment.newInstance();
                case 1:
                    return Services.sModule2Service.module2TabFragment();
                default:
                    throw new IllegalArgumentException("Illegal adapter index " + position);
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.module1);
                case 1:
                    return getString(R.string.module2);
                default:
                    throw new IllegalArgumentException("Illegal adapter index " + position);
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}
