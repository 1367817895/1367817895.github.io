package com.example.x.frag;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.x.adapter.MyPagerAdapter;
import com.example.x.liuqingsong0121.R;
import com.qy.channel.ChannelActivity;
import com.qy.channel.bean.ChannelItem;
import com.qy.channel.db.DBUtil;

import java.util.ArrayList;

/**
 * @Auther: 刘青松
 * @Date: 2019/1/21 09:26:24
 * @Description:
 */
public class Frag01  extends Fragment {

    private TabLayout tabLayout;
    private ViewPager pager;
    private ArrayList<ChannelItem> userlist;
    private ArrayList<Fragment> fragmentlist;
    private MyPagerAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frago1, container, false);
        tabLayout = view.findViewById(R.id.tab);
        pager = view.findViewById(R.id.pager);
        userlist = DBUtil.getTabData(getActivity());
        fragmentlist = new ArrayList<>();
        for (int i=0;i<userlist.size();i++){
            fragmentlist.add(new Frag1());
        }
        adapter = new MyPagerAdapter( getActivity().getSupportFragmentManager(),fragmentlist,userlist);
 pager.setAdapter(adapter);
 tabLayout.setupWithViewPager(pager);

        view.findViewById(R.id.tabmeun);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ChannelActivity.class);
        startActivityForResult(intent,0);

            }
        });  return view;   }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    if (resultCode==0){
        userlist = DBUtil.getTabData(getActivity());
for (int i=0;i<userlist.size();i++){
    ChannelItem channelItem = userlist.get(i);
    String name = channelItem.getName();
    tabLayout.addTab(tabLayout.newTab().setText(name));
}  adapter = new MyPagerAdapter( getActivity().getSupportFragmentManager(),fragmentlist,userlist);
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager);
  }  }
}
