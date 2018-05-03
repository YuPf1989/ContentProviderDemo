package com.rain.contentproviderdemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Author:rain
 * Date:2018/5/3 15:16
 * Description:
 * 创建数据库的帮助类
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG  = "MySQLiteOpenHelper";
    public MySQLiteOpenHelper(Context context) {
        super(context, "student.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student(_id integer primary key autoincrement," +
                "name varchar(20),number varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e(TAG, "onUpgrade: ");
    }
}
