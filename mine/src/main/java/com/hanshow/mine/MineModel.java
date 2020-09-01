package com.hanshow.mine;


import com.zz.http.RetrofitHelper;
import com.zz.mvp.rx.RxHelper;

import io.reactivex.Observable;

public class MineModel implements MineContact.IMineModel {

    @Override
    public Observable<MineBean> login(String userName, String password) {
        return RetrofitHelper.getApi(MineApi.class).login(userName, password)
                .compose(RxHelper.<MineBean>rxSchedulerHelper());
    }
}
