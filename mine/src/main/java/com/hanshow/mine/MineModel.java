package com.hanshow.mine;


import com.zz.http.RetrofitHelper;
import com.zz.mvp.rx.RxHelper;

import io.reactivex.Observable;

public class MineModel implements MineContact.IMineModel {
    @Override
    public Observable<MineBean> getWelfare() {
        return RetrofitHelper.getApi(MineApi.class).getWelfare()
                .compose(RxHelper.<MineBean>rxSchedulerHelper());
    }
}
