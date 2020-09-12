package com.hanshow.project

import com.hanshow.base.BaseRepository
import com.hanshow.bean.NetResult
import com.zz.http.RetrofitHelper

class ProjectRepository : BaseRepository() {

    suspend fun getProject(cid: Int): NetResult<ProjectBean> {
        return callRequest(call = { requestProject(cid) })
    }

    private suspend fun requestProject(
            cid: Int): NetResult<ProjectBean> {
        return execRequest(RetrofitHelper.getApi(ProjectApi::class.java).getProject(cid))
    }
}