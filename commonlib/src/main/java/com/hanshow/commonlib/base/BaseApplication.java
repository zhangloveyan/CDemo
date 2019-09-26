package com.hanshow.commonlib.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author Zz 张立男
 * @Description BaseApplication 基类
 * @date 2019/9/26 15:04
 * o(＞﹏＜)o
 */
public class BaseApplication extends Application {
    private static BaseApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;


        initARouter();
    }

    private void initARouter() {
        ARouter.openDebug();
        ARouter.openLog();
        ARouter.init(this);
    }

    public static BaseApplication getApplication() {
        return application;
    }

}
