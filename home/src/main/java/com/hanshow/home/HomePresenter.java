package com.hanshow.home;

import com.hanshow.commonlib.base.ResultBean;

import io.reactivex.functions.Consumer;

public class HomePresenter extends HomeContact.IHomePresenter {
    @Override
    public void getHomeBanner() {
        mRxManager.register(mIModel.getHomeBanner().subscribe(new Consumer<ResultBean<HomeBannerBean>>() {
            @Override
            public void accept(ResultBean<HomeBannerBean> bean) throws Exception {
                if (bean.getErrorCode() == 0) {
                    mIView.setBanner(bean.getData());
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        }));
    }

    @Override
    public void getHomeList(int page) {

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
