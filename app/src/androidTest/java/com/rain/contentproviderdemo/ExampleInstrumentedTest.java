package com.rain.contentproviderdemo;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private static final String TAG  = "ExampleInstrumentedTest";
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.rain.contentproviderdemo", appContext.getPackageName());
    }

    @Test
    public void query() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        ContentResolver resolver = appContext.getContentResolver();
        Uri uri = Uri.parse("content://com.rain.contentproviderdemo.MyProvider/student/2");
        Cursor cursor = resolver.query(uri, null, null, null, null);
        while (cursor.moveToNext()) {
            Log.e(TAG, "query: "+cursor.getString(cursor.getColumnIndex("name")));
        }
    }
}
