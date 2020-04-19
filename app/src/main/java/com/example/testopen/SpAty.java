package com.example.testopen;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import sf.gs.slideunlocklib.ISlideChangeListener;
import sf.gs.slideunlocklib.SlideLayout;
import sf.gs.slideunlocklib.renderers.ScaleRenderer;
import sf.gs.slideunlocklib.sliders.HorizontalSlider;
import sf.gs.slideunlocklib.textview.ShiningFontView;


public class SpAty extends AppCompatActivity {

    ShiningFontView tvPickupPointName;

    FrameLayout slideChild;

    ImageView ivSlideUnlockImg;

    SlideLayout slideLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sp_aty);

        tvPickupPointName = findViewById(R.id.tv_pickup_point_name);

        ivSlideUnlockImg = findViewById(R.id.iv_slide_unlock_img);

        slideChild = findViewById(R.id.slide_child);

        slideLayout = findViewById(R.id.slide_layout);

        //设置字
        tvPickupPointName.setText("滑动解锁");

        slideUnlockInit();
    }

    private void slideUnlockInit() {

        //滚动标志动画开启
        AnimationDrawable drawable = (AnimationDrawable) ivSlideUnlockImg.getDrawable();

        drawable.start();

        //设置监听
        slideLayout.setRenderer(new ScaleRenderer());
        slideLayout.setSlider(new HorizontalSlider());


        //设置滑动按钮的父布局
        slideLayout.setChildId(R.id.slide_child);


        //设置滑动完成的长度  数值越小 滑动的越短
        slideLayout.setThreshold(0.1f);


        // 滑动开锁的监听
        slideLayout.addSlideChangeListener(new ISlideChangeListener() {
            //滑动开始
            @Override
            public void onSlideStart(SlideLayout slider) {
                slider.reset();
            }
            //滑动变化的监听
            @Override
            public void onSlideChanged(SlideLayout slider, float percentage) {
                tvPickupPointName.setAlpha(1 - percentage);
            }
            //滑动完成
            @Override
            public void onSlideFinished(SlideLayout slider, boolean done) {
                if (done) {
                    slider.reset();
                    startActivity(new Intent(SpAty.this,MainActivity.class));
//                    Toast.makeText(SpAty.this, "滑动完成", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
