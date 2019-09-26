package com.hanshow.cdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.hanshow.commonlib.constants.Page;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ARouter.getInstance().inject(this);

        TextView tvHome = findViewById(R.id.tv_app_home);
        TextView tvMine = findViewById(R.id.tv_app_mine);

        tvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(Page.HOME).navigation();
            }
        });

        tvMine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(Page.MINE).navigation();
            }
        });
    }
}
