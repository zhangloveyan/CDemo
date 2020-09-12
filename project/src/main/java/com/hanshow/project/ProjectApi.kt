package com.hanshow.project

import com.hanshow.bean.BaseResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProjectApi {

    @GET("project/list/{page}/json")
    suspend fun getProject(@Path("page") page: Int, @Query("cid") cid: Int): BaseResult<ProjectBean>
}