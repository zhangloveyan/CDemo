package com.hanshow.home;

import com.hanshow.commonlib.base.ResultBean;
import com.zz.http.RetrofitHelper;
import com.zz.mvp.rx.RxHelper;

import java.util.List;

import io.reactivex.Observable;

public class HomeModel implements HomeContact.IHomeModel {
    @Override
    public Observable<ResultBean<List<HomeBannerBean>>> getHomeBanner() {
        return RetrofitHelper.getApi(HomeApi.class).getHomeBanner()
                .compose(RxHelper.<ResultBean<List<HomeBannerBean>>>rxSchedulerHelper());
    }

    @Override
    public Observable<ResultBean<HomeListBean>> getHomeList(int page) {
        return RetrofitHelper.getApi(HomeApi.class).getHomeList(page)
                .compose(RxHelper.<ResultBean<HomeListBean>>rxSchedulerHelper());
    }
}
