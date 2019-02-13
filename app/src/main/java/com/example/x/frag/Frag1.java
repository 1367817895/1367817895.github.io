package com.example.x.frag;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.x.adapter.Frag1Adapter;
import com.example.x.bean.JavaBean;
import com.example.x.bean.JavaBean1;
import com.example.x.dao.Dao;
import com.example.x.http.Http;
import com.example.x.liuqingsong0121.R;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qy.xlistview.XListView;

import java.util.ArrayList;

/**
 * @Auther: 刘青松
 * @Date: 2019/1/21 09:45:20
 * @Description:
 */
public class Frag1 extends Fragment {

 
    private ArrayList<JavaBean> list;
    private Dao dao;
    private Cursor person;
    private long l;
    private Frag1Adapter frag1Adapter;
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag1, container, false);
        listView = view.findViewById(R.id.pull);
        list = new ArrayList<>();
        dao = new Dao(getActivity());

            new Thread() {

                private String s;
                @Override
                public void run() {
                    super.run();
                    s = Http.httpGet("http://api.expoon.com/AppNews/getNewsList/type/1/p/1");
                    Gson gson = new Gson();
                    JavaBean1 bean1 = gson.fromJson(s, JavaBean1.class);
                    list = bean1.getData();
       Message message = new Message();

                    message.obj = list;
                    handler.sendMessage(message);


                }
            }.start();

    return view;
    }
  @SuppressLint("HandlerLeak")
  Handler handler=new Handler(){

      @Override
      public void handleMessage(Message msg) {
          super.handleMessage(msg);

                  Toast.makeText(getActivity(),"成功",Toast.LENGTH_SHORT).show();

                  list= (ArrayList<JavaBean>) msg.obj;
                  person = dao.query("person", null, null, null, null, null, null);

    ContentValues values=new ContentValues();
    for (int i=0;i<list.size();i++) {
         values.put("news_id",list.get(i).getNews_id());
        values.put("pic_url",list.get(i).getPic_url());
        values.put("news_title",list.get(i).getNews_title());
        values.put("news_summary",list.get(i).getNews_summary());
       l = dao.insert("person", null, values);
    }

                  frag1Adapter = new Frag1Adapter(list,getActivity());
listView.setAdapter(frag1Adapter);


//              case 3:
//                  list= new  ArrayList<>() ;
//                  person = dao.query("person", null, null, null, null, null, null);
//                  if (person.moveToFirst()){
//                      do {
//                          String content = person.getString(person.getColumnIndex("content"));
//                          String image_url = person.getString(person.getColumnIndex("image_url"));
//                          String title = person.getString(person.getColumnIndex("title"));
//                           int id = person.getInt(person.getColumnIndex("id"));
//                          int type = person.getInt(person.getColumnIndex("type"));
//                          JavaBean javaBean = new JavaBean(content+"",id,image_url,title+"",type);
//                          list.add(javaBean);
//
//                      }while (person.moveToNext());  }
//                  Toast.makeText(getActivity(),list.size()+" ",Toast.LENGTH_SHORT).show();
//                  frag1Adapter = new Frag1Adapter(list,getActivity());
//                  listView.setAdapter(frag1Adapter);
//                    break;




      }
  };


}
