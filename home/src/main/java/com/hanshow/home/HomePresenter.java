package com.hanshow.home;

import com.hanshow.commonlib.base.ResultBean;

import java.util.List;

import io.reactivex.functions.Consumer;

public class HomePresenter extends HomeContact.IHomePresenter {
    @Override
    public void getHomeBanner() {
        mRxManager.register(mIModel.getHomeBanner().subscribe(new Consumer<ResultBean<List<HomeBannerBean>>>() {
            @Override
            public void accept(ResultBean<List<HomeBannerBean>> bean) throws Exception {
                mIView.setBanner(bean.getData());
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        }));
    }

    @Override
    public void getHomeList(int page) {
        mRxManager.register(mIModel.getHomeList(page).subscribe(new Consumer<ResultBean<HomeListBean>>() {
            @Override
            public void accept(ResultBean<HomeListBean> bean) throws Exception {
                if (bean.getErrorCode() == 0) {
                    mIView.setList(bean.getData());
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        }));
    }

    @Override
    protected HomeContact.IHomeModel getModel() {
        return new HomeModel();
    }

    @Override
    public void onStart() {
        getHomeBanner();
        getHomeList(0);
    }
}
