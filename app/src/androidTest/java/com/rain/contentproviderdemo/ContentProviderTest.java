package com.rain.contentproviderdemo;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.test.AndroidTestCase;
import android.util.Log;

/**
 * Author:rain
 * Date:2018/5/3 16:51
 * Description:
 */
public class ContentProviderTest extends AndroidTestCase {
    private static final String TAG   = "ContentProviderTest";

    public void testQuery() {
        Context appContext = getContext();
        ContentResolver resolver = appContext.getContentResolver();
        Uri uri = Uri.parse("content://com.rain.contentproviderdemo.MyProvider/student/2");
        Cursor cursor = resolver.query(uri, null, null, null, null);
        while (cursor.moveToNext()) {
            Log.e(TAG, "query: "+cursor.getString(cursor.getColumnIndex("name")));
        }
    }
}
