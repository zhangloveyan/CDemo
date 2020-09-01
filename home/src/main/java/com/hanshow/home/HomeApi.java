package com.hanshow.home;

import com.hanshow.commonlib.base.ResultBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HomeApi {
    /**
     * 获取banner数据
     *
     * @return
     */
    @GET("banner/json")
    Observable<ResultBean<List<HomeBannerBean>>> getHomeBanner();

    /**
     * 首页列表
     *
     * @param page
     * @return
     */
    @GET("article/list/{page}/json")
    Observable<ResultBean<HomeListBean>> getHomeList(@Path("page") int page);
}
