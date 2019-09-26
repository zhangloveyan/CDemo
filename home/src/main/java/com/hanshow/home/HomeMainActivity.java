package com.hanshow.home;

import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.hanshow.commonlib.base.BaseActivity;
import com.hanshow.commonlib.constants.Page;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

/**
 * @author Zz 张立男
 * @Description HomeMainActivity 首页
 * @date 2019/9/26 15:21
 * o(＞﹏＜)o
 */
@Route(path = Page.HOME)
public class HomeMainActivity extends BaseActivity<HomePresenter> implements HomeContact.IHomeView {

    private RecyclerView mRvHome;
    private ViewPager mVpHome;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_main;
    }

    @Override
    protected void init() {
        mRvHome = findViewById(R.id.rv_home);
        mVpHome = findViewById(R.id.vp_home);


    }

    @Override
    protected HomePresenter getPresenter() {
        return new HomePresenter();
    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void setBanner(HomeBannerBean bannerBean) {
        List<ImageView> list = new ArrayList<>();

        List<HomeBannerBean.DataBean> data = bannerBean.getData();
        for (HomeBannerBean.DataBean dataBean : data) {
            ImageView iv = new ImageView(HomeMainActivity.this);
            Glide.with(HomeMainActivity.this)
                    .load(dataBean.getUrl())
                    .into(iv);
            list.add(iv);
        }
        HomePageAdapter pageAdapter = new HomePageAdapter(list);

        mVpHome.setAdapter(pageAdapter);
    }
}
