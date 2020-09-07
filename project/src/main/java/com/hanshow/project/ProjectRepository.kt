package com.hanshow.project

import com.zz.http.RetrofitHelper

class ProjectRepository {
    suspend fun getProject(cid:Int): ProjectBean {
        return RetrofitHelper.getApi(ProjectApi::class.java).getProject(cid)
    }
}