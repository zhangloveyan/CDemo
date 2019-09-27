package com.hanshow.mine;

import android.widget.ImageView;

import androidx.viewpager.widget.PagerTitleStrip;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bumptech.glide.Glide;
import com.hanshow.commonlib.base.BaseActivity;
import com.hanshow.commonlib.constants.Page;

import java.util.ArrayList;
import java.util.List;

@Route(path = Page.MINE)
public class MineMainActivity extends BaseActivity<MinePresenter> implements MineContact.IMineView {

    private ViewPager mVpMine;
    private PagerTitleStrip mPtsMine;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mine_main;
    }

    @Override
    protected void init() {
        mVpMine = findViewById(R.id.vp_mine);
        mPtsMine = findViewById(R.id.pts_mine);
    }

    @Override
    protected MinePresenter getPresenter() {
        return new MinePresenter();
    }

    @Override
    public void setWelfare(List<MineBean.ResultsBean> data) {
        List<ImageView> list = new ArrayList<>();

        for (MineBean.ResultsBean dataBean : data) {
            ImageView iv = new ImageView(MineMainActivity.this);
            Glide.with(MineMainActivity.this)
                    .load(dataBean.getUrl())
                    .into(iv);
            list.add(iv);
        }
        MinePageAdapter pageAdapter = new MinePageAdapter(list);

        mVpMine.setAdapter(pageAdapter);


    }

    @Override
    public void showToast(String msg) {

    }
}
