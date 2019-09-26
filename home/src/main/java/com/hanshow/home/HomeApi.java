package com.hanshow.home;

import com.hanshow.commonlib.base.ResultBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HomeApi {
    /**
     * 获取banner数据
     *
     * @return
     */
    @GET("https://www.wanandroid.com/banner/json")
    Observable<ResultBean<HomeBannerBean>> getHomeBanner();

    /**
     * 首页列表
     *
     * @param page
     * @return
     */
    @GET("https://www.wanandroid.com/article/list/{page}/json")
    Observable<ResultBean<HomeListBean>> getHomeList(@Path("page") int page);
}
