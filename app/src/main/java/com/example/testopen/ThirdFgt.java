package com.example.testopen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import static androidx.fragment.app.FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

public class ThirdFgt extends Fragment {


    private ViewPager viewPager;

    private TabLayout tabLayout1;


    private ViewPagerAdapter carTypeViewAdapter;  //中间界面的适配器

    private ArrayList<String> carStringList = new ArrayList<>();  //中间界面的标题列表

    private ArrayList<Fragment> carTypeFragmentList = new ArrayList<Fragment>();  //中间界面的布局列表

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fgt_third, container, false);
        initView(view);
        return view;
    }

    public void initView(View view) {
        //中间界面的标题列表 添加数据
        carStringList.add("头条");
        carStringList.add("社会");
        carStringList.add("国内");
        //初始化Fragment布局
        NewsFgt carTypeFragment1 = NewsFgt.newInstance();
        News2Fgt carTypeFragment2 = News2Fgt.newInstance();
        News3Fgt carTypeFragment3 = News3Fgt.newInstance();
        //中间界面的布局列表 添加数据
        carTypeFragmentList.add(carTypeFragment1);
        carTypeFragmentList.add(carTypeFragment2);
        carTypeFragmentList.add(carTypeFragment3);
        //适配器实例化 以及传入数据
        carTypeViewAdapter = new ViewPagerAdapter(getChildFragmentManager(), carStringList, carTypeFragmentList, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        viewPager = view.findViewById(R.id.vp_cartype);
        viewPager.setAdapter(carTypeViewAdapter);
        tabLayout1 = view.findViewById(R.id.huoyun_tablayout);
        tabLayout1.setupWithViewPager(viewPager);

    }
}
