package com.hanshow.mine;

import com.zz.http.RetrofitHelper;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface MineApi {
    String MineHost = "http://gank.io/";

    /**
     * 获取banner数据
     *
     * @return
     */
    @Headers(RetrofitHelper.URL_HOST + MineHost)
    @GET("api/data/%E7%A6%8F%E5%88%A9/20/1")
    Observable<MineBean> getWelfare();
}
