package com.hanshow.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * @author Zz 张立男
 * @Description HomeMainActivity 首页
 * @date 2019/9/26 15:21
 * o(＞﹏＜)o
 */
@Route(path = "/home/main")
public class HomeMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_main);
    }
}
