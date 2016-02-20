package com.example.alin.memoxvp.adapter;

import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.alin.memoxvp.fragment.FirstLayout;
import com.example.alin.memoxvp.fragment.ThirdLayout;
import com.example.alin.memoxvp.fragment.SecondLayout;

/**
 * Created by vasin on 2/10/2016.
 */
public class WalkthroughAdapter extends FragmentStatePagerAdapter{

    public static final int PAGE_COUNT = 3;
    Typeface boldTypeface;
    Typeface thinTypeface;

    public WalkthroughAdapter(FragmentManager fragmentManager,Typeface boldTypeface, Typeface thinTypeface){
        super(fragmentManager);
        this.boldTypeface = boldTypeface;
        this.thinTypeface = thinTypeface;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                FirstLayout firstLayout = new FirstLayout();
                firstLayout.setTypeface(boldTypeface,thinTypeface);
                return firstLayout;
            case 1:
                SecondLayout secondLayout = new SecondLayout();
                secondLayout.setTypeface(boldTypeface,thinTypeface);
                return secondLayout;
            case 2:
                ThirdLayout thirdLayout = new ThirdLayout();
                thirdLayout.setTypeface(boldTypeface,thinTypeface);
                return thirdLayout;
        }
        return null;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
