package com.hanshow.commonlib.base;

import com.zz.mvp.base.BaseMvpActivity;
import com.zz.mvp.base.BaseMvpPresenter;

/**
 * @author Zz 张立男
 * @Description BaseActivity 业务基础类
 * @date 2019/3/14 21:55
 * o(＞﹏＜)o
 */

public abstract class BaseActivity<P extends BaseMvpPresenter> extends BaseMvpActivity<P> {

    @Override
    public void showProgress() {
//        LoadingUtils.loading(this);
    }

    @Override
    public void hideProgress() {
//        LoadingUtils.close();
    }

}
