package com.example.testopen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.next.easynavigation.view.EasyNavigationBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] tabText = {"首页", "发现", "热点"};
    //未选中icon
    private int[] normalIcon = {R.mipmap.icon_shou, R.mipmap.icon_lu, R.mipmap.icon_re};
    //选中时icon
    private int[] selectIcon = {R.mipmap.icon_shou_back, R.mipmap.icon_lu_back, R.mipmap.icon_re_back};

    private List<Fragment> fragments = new ArrayList<>();

    private EasyNavigationBar navigationBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView() {

        navigationBar = findViewById(R.id.navigationBar);
        fragments.add(new OneFgt());
        fragments.add(new ThirdFgt());
        fragments.add(new TwoFgt());

        navigationBar.titleItems(tabText)
                .normalIconItems(normalIcon)
                .selectIconItems(selectIcon)
                .fragmentList(fragments)
                .fragmentManager(getSupportFragmentManager())
                .build();
    }
}
