package com.example.x.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.qy.channel.bean.ChannelItem;

import java.util.ArrayList;

/**
 * @Auther: 刘青松
 * @Date: 2019/1/21 09:47:09
 * @Description:
 */
public class MyPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragmentlist;
    ArrayList<ChannelItem> userlist;
  public MyPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragmentlist, ArrayList<ChannelItem> userlist) {
        super(fm);
        this.fragmentlist = fragmentlist;
        this.userlist = userlist;

    }

    @Override
    public Fragment getItem(int i) {
        return fragmentlist.get(i);
    }

    @Override
    public int getCount() {
        return userlist.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return userlist.get(position).getName();
    }
}
