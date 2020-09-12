package com.hanshow.project

import com.hanshow.bean.BaseResult
import retrofit2.http.GET
import retrofit2.http.Query

interface ProjectApi {

    @GET("project/list/1/json")
    suspend fun getProject(@Query("cid") cid: Int): BaseResult<ProjectBean>
}