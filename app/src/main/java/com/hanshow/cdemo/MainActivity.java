package com.hanshow.cdemo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.hanshow.commonlib.constants.Page;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_main);

        ARouter.getInstance().inject(this);

        ARouter.getInstance().build(Page.MINE).navigation();
        finish();
    }
}
