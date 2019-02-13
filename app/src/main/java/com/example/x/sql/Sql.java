package com.example.x.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @Auther: 刘青松
 * @Date: 2019/1/21 08:42:24
 * @Description:
 */
public class Sql extends SQLiteOpenHelper {
    public Sql( Context context ) {
        super(context,"jb.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

db.execSQL("create table person(news_id varchar(20),news_summary varchar(20),news_title varchar(20),pic_url varchar(20))");
  }
//       "": "13785",
//               "": "2016年1月14日，第八届中国(广州)国际集成住宅产业博览会暨2016亚太建筑科技论坛——新闻发布会在广州馆隆重召开。",
//               "news_title": "第八届中国国际集成住宅产业博览会将于5月在广州举办",
//               "pic_url": "http://f.expoon.com/sub/news/2016/01/18/581830_230x162_0.jpg"

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
