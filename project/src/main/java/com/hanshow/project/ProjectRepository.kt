package com.hanshow.project

import com.hanshow.base.BaseRepository
import com.hanshow.bean.NetResult
import com.zz.http.RetrofitHelper

class ProjectRepository : BaseRepository() {

    suspend fun getProject(page: Int, cid: Int): NetResult<ProjectBean> {
        return callRequest(call = { requestProject(page, cid) })
    }

    private suspend fun requestProject(
            page: Int,
            cid: Int): NetResult<ProjectBean> {
        return execRequest(RetrofitHelper.getApi(ProjectApi::class.java).getProject(page, cid))
    }
}