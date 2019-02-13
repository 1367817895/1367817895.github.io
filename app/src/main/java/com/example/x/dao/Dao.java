package com.example.x.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.x.sql.Sql;

/**
 * @Auther: 刘青松
 * @Date: 2019/1/21 08:42:11
 * @Description:
 */
public class Dao {

    private final SQLiteDatabase db;

    public  Dao(Context context){
        Sql sql = new Sql(context);
        db = sql.getWritableDatabase();


    }
    public long insert(String table, String nullColumnHack, ContentValues values) {

        return db.insert(table, nullColumnHack, values);
    }
    public int delete(String table, String whereClause, String[] whereArgs) {

        return db.delete(table, whereClause, whereArgs);
    }
    public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {

        return db.update(table, values, whereClause, whereArgs);
    }
    public Cursor query(String table, String[] columns, String selection,
                        String[] selectionArgs, String groupBy, String having,
                        String orderBy) {

        return db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
    }




}
