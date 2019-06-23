package com.example.hp.balanceddiet;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class shanyaoPageAdapter extends FragmentPagerAdapter{
    shanyaoPageAdapter(FragmentManager manager){
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new shanyaoword();
        }else {
            return new shanyaovideo();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return  "图文讲解";
        }else{
            return  "视频讲解";
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
