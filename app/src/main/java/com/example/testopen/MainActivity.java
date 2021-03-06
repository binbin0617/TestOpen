package com.example.testopen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.next.easynavigation.view.EasyNavigationBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] tabText = {"首页", "发现", "热点"};//标题列表
    //  首页下面的三个图片未选中icon
    private int[] normalIcon = {R.mipmap.icon_shou, R.mipmap.icon_lu, R.mipmap.icon_re};
    //首页下面的三个图片  选中时icon
    private int[] selectIcon = {R.mipmap.icon_shou_back, R.mipmap.icon_lu_back, R.mipmap.icon_re_back};

    private List<Fragment> fragments = new ArrayList<>();   //布局列表

    private EasyNavigationBar navigationBar;   //     //https://github.com/Vincent7Wong/EasyNavigation  介绍地址
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView() {
        //跟布局文件里面匹配
        navigationBar = findViewById(R.id.navigationBar);

        //布局列表进行添加
        fragments.add(new OneFgt());
        fragments.add(new ThirdFgt());
        fragments.add(new TwoFgt());


        //设置布局和标题 以及按钮
        navigationBar.titleItems(tabText)
                .normalIconItems(normalIcon)
                .selectIconItems(selectIcon)
                .fragmentList(fragments)
                .fragmentManager(getSupportFragmentManager())
                .build();
    }
}
