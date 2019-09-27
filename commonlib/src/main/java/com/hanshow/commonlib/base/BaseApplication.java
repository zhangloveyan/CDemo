package com.hanshow.commonlib.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.hanshow.commonlib.BuildConfig;
import com.zz.http.RetrofitHelper;

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

        RetrofitHelper.getInstance()
                .baseUrl("https://www.wanandroid.com/")
                .debug(BuildConfig.DEBUG)
                .init(this);

        modulesApplicationInit();
    }

    /**
     * 初始化子类 application 的东西
     */
    private void modulesApplicationInit() {
        for (String model : ModelConfig.MODEL_APP_LIST) {
            try {
                Class<?> aClass = Class.forName(model);
                Object obj = aClass.newInstance();
                if (obj instanceof ApplicationImpl) {
                    ((ApplicationImpl) obj).onCreate(this);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
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
