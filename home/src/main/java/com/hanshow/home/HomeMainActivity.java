package com.hanshow.home;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hanshow.commonlib.base.BaseActivity;
import com.hanshow.commonlib.constants.Page;

/**
 * @author Zz 张立男
 * @Description HomeMainActivity 首页
 * @date 2019/9/26 15:21
 * o(＞﹏＜)o
 */
@Route(path = Page.HOME)
public class HomeMainActivity extends BaseActivity<HomePresenter> implements HomeContact.IHomeView {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_main;
    }

    @Override
    protected void init() {

    }

    @Override
    protected HomePresenter getPresenter() {
        return new HomePresenter();
    }

    @Override
    public void showToast(String msg) {

    }
}
