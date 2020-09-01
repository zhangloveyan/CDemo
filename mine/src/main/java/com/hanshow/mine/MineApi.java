package com.hanshow.mine;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MineApi {

    /**
     * 登录
     *
     * @return
     */
    @POST("user/login")
    Observable<MineBean> login(@Query("username") String userName,
                               @Query("password") String password);
}
