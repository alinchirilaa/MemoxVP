package com.example.alin.memoxvp.fragment;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.alin.memoxvp.R;

import com.example.alin.memoxvp.adapter.WalkthroughAdapter;

/**
 * Created by vasin on 2/10/2016.
 */
public class WalkthroughActivity extends AppCompatActivity {

    View decorateView;
    ViewPager mViewPager;
    GradientDrawable firstIndicator,secondIndicator,thirdIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        decorateView = getWindow().getDecorView();
        setContentView(R.layout.activity_main);

        Typeface boldTypeface = Typeface.createFromAsset(getAssets(), "fonts/System San Francisco Display Bold.ttf");
        Typeface thinTypeface = Typeface.createFromAsset(getAssets(), "fonts/System San Francisco Display Regular.ttf");

        firstIndicator = (GradientDrawable) findViewById(R.id.first_indicator).getBackground();
        secondIndicator = (GradientDrawable) findViewById(R.id.second_indicator).getBackground();
        thirdIndicator = (GradientDrawable) findViewById(R.id.third_indicator).getBackground();

        firstIndicator.setColor(Color.BLACK);

        WalkthroughAdapter mPagerAdapter = new WalkthroughAdapter(getSupportFragmentManager(), boldTypeface, thinTypeface);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(mPagerAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        firstIndicator.setColor(Color.BLACK);
                        secondIndicator.setColor(Color.TRANSPARENT);
                        break;
                    case 1:
                        secondIndicator.setColor(Color.BLACK);
                        firstIndicator.setColor(Color.TRANSPARENT);
                        thirdIndicator.setColor(Color.TRANSPARENT);
                        break;
                    case 2:
                        thirdIndicator.setColor(Color.BLACK);
                        secondIndicator.setColor(Color.TRANSPARENT);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        decorateView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        decorateView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

}
