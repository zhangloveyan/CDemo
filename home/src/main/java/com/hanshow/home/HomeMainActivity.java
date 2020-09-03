package com.hanshow.home;

import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.hanshow.commonlib.base.BaseActivity;
import com.hanshow.commonlib.constants.Page;

import java.util.ArrayList;
import java.util.List;

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
    private HomeListAdapter mListAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_main;
    }

    @Override
    protected void init() {
        mRvHome = findViewById(R.id.rv_home);
        mVpHome = findViewById(R.id.vp_home);
        ARouter.getInstance().inject(this);
        initRv();

        findViewById(R.id.bt_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(Page.PROJECT).navigation();            }
        });
    }

    private void initRv() {
        mListAdapter = new HomeListAdapter(null, this);
        mRvHome.setLayoutManager(new LinearLayoutManager(this));
        mRvHome.setAdapter(mListAdapter);
    }

    @Override
    protected HomePresenter getPresenter() {
        return new HomePresenter();
    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void setBanner(List<HomeBannerBean> data) {
        List<ImageView> list = new ArrayList<>();

        for (HomeBannerBean dataBean : data) {
            ImageView iv = new ImageView(HomeMainActivity.this);
            Glide.with(HomeMainActivity.this)
                    .load(dataBean.getImagePath())
                    .into(iv);
            list.add(iv);
        }
        HomePageAdapter pageAdapter = new HomePageAdapter(list);

        mVpHome.setAdapter(pageAdapter);
    }

    @Override
    public void setList(HomeListBean listBean) {
        List<HomeListBean.DatasBean> datas = listBean.getDatas();
        mListAdapter.refreshRv(datas);
    }
}
