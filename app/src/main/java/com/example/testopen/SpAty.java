package com.example.testopen;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

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

        slideLayout.setRenderer(new ScaleRenderer());
        slideLayout.setSlider(new HorizontalSlider());

        slideLayout.setChildId(R.id.slide_child);
        slideLayout.setThreshold(0.85f);
        slideLayout.addSlideChangeListener(new ISlideChangeListener() {
            @Override
            public void onSlideStart(SlideLayout slider) {
                slider.reset();
            }

            @Override
            public void onSlideChanged(SlideLayout slider, float percentage) {
                tvPickupPointName.setAlpha(1 - percentage);
            }

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
