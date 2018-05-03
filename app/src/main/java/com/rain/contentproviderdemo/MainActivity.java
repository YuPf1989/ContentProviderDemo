package com.rain.contentproviderdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * content_provider demo
 * https://www.cnblogs.com/cy666/p/7505875.html
 * https://www.cnblogs.com/plokmju/p/android_ContentProvider.html
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private StudentDao studentDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_add_data).setOnClickListener(this);
        studentDao = new StudentDao(this);

    }

    private int index = 0;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_data:
                index++;
                studentDao.add("小米" + index, index + "");
                break;
        }
    }
}
