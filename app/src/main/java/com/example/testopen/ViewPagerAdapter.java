package com.example.testopen;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * viewpager  的适配器
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<String> titleList;   //标题列表
    private ArrayList<Fragment> fragmentList;   //布局列表

    //BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
    public ViewPagerAdapter(FragmentManager fm, ArrayList<String> titleList, ArrayList<Fragment> fragmentList, int behavior) {
        super(fm,behavior);
        this.titleList = titleList;
        this.fragmentList = fragmentList;
    }



    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
