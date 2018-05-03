package com.rain.contentproviderdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Author:rain
 * Date:2018/5/3 15:44
 * Description:
 * 向student表中添加数据
 */
public class StudentDao {

    private final MySQLiteOpenHelper helper;

    public StudentDao(Context context) {
        helper = new MySQLiteOpenHelper(context);
    }

    public long add(String name,String number) {
        SQLiteDatabase database = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",name);
        values.put("number",number);
        // TODO: 2018/5/3 返回的应当是当前插入的下标
        long l = database.insert("student", number, values);
        database.close();
        return l;
    }
}
