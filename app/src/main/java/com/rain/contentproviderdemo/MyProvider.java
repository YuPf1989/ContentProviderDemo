package com.rain.contentproviderdemo;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Author:rain
 * Date:2018/5/3 15:01
 * Description:
 */
public class MyProvider extends ContentProvider {
    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);
    private static final String AUTHORITY = "com.rain.contentproviderdemo.MyProvider";
    private static final int STUDENT = 1;
    private static final int STUDENTS = 2;
    private MySQLiteOpenHelper helper;
    private static final String TAG = "MyProvider";

    // 添加uri筛选
    static {
        URI_MATCHER.addURI(AUTHORITY, "student", STUDENTS);
        // 使用通配符，匹配任意数字
        URI_MATCHER.addURI(AUTHORITY, "student/#", STUDENT);
    }


    // 1.MyProvider一加载,就走onCreate()方法,就链接数据库
    @Override
    public boolean onCreate() {
        helper = new MySQLiteOpenHelper(getContext());
        return false;
    }

    // 2.暴露你想暴露的方法(增删改查方法),以暴露query方法为例
    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        int code = URI_MATCHER.match(uri);
        Cursor cursor = null;
        switch (code) {
            case STUDENT:
                long id = ContentUris.parseId(uri);// 貌似是查询参数
                String where_value = "_id = ?";// 查询条件
                String[] args = {String.valueOf(id)};
                SQLiteDatabase db = helper.getWritableDatabase();
                // TODO: 2018/5/3 待测试
                cursor = db.query("student", projection, where_value, args, null, null, null, sortOrder);
                Log.e(TAG, "cursor.count(): " + cursor.getCount());
                return cursor;
            case STUDENTS:
                Log.e(TAG, "query: STUDENTS");
                break;

            default:
                Log.e(TAG, "未匹配到uri路径！");
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
