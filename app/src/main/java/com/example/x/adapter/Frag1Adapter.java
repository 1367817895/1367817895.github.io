package com.example.x.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.x.bean.JavaBean;
import com.example.x.liuqingsong0121.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * @Auther: 刘青松
 * @Date: 2019/1/21 10:23:13
 * @Description:
 */
public class Frag1Adapter extends BaseAdapter {
   private ArrayList<JavaBean> list;
  private   Context context;
    private View view;
    private ViewHolder holder;
    private ViewHolder2 holder2;

    public Frag1Adapter(ArrayList<JavaBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return position%2;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch (getItemViewType(position)) {
            case 0:
                if (convertView == null) {
                    convertView = LayoutInflater.from(context).inflate(R.layout.frag1item, null);
                    holder = new ViewHolder();
                    holder.imageView = convertView.findViewById(R.id.img2);
                    holder.textView = convertView.findViewById(R.id.text1);
                    convertView.setTag(holder);


                } else {

                    holder = (ViewHolder) convertView.getTag();

                }
                String path = list.get(position).getPic_url();
                DisplayImageOptions options = new DisplayImageOptions.Builder()
                        .cacheInMemory(true)
                        .cacheOnDisk(true)
                        .build();
                ImageLoader.getInstance().displayImage(path, holder.imageView, options);

                holder.textView.setText(list.get(position).getNews_id());

                break;


            case 1:
                if (convertView == null) {
                    convertView = LayoutInflater.from(context).inflate(R.layout.frag1item2, null);
                    holder2 = new ViewHolder2();
                    holder2.textView2 = convertView.findViewById(R.id.text2);
                    convertView.setTag(holder2);


                } else {

                    holder2 = (ViewHolder2) convertView.getTag();

                }

                holder2.textView2.setText(list.get(position).getNews_summary());

                break;


        }
        return convertView;}
    class ViewHolder{
        ImageView imageView;
        TextView textView;

    }  class ViewHolder2{

        TextView textView2;

    }

}
