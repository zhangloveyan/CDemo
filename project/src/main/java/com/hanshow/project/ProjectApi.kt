package com.hanshow.project

import retrofit2.http.GET
import retrofit2.http.Query

interface ProjectApi {

    //    https://www.wanandroid.com/project/list/1/json?cid=294
    @GET("project/list/1/json")
    suspend fun getProject(@Query("cid") cid: Int): ProjectBean
}