package com.hanshow.project

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hanshow.base.BaseViewModel
import kotlinx.coroutines.launch

class ProjectModel : BaseViewModel() {

    var mLiveListProjectBean = MutableLiveData<DataList<DataX>>()
    private var projectRepository = ProjectRepository()
    private val total = 4
    var currentPage = 1

    fun getProject(isRefresh: Boolean) {

        if (isRefresh) {
            currentPage = 1
        }

        if (currentPage <= total) {
            viewModelScope.launch {
                val result = projectRepository.getProject(currentPage, 294)

                result.checkResult({
                    currentPage++

                    mLiveListProjectBean.postValue(DataList(isRefresh, it.datas))
                    refreshComplete.postValue(true)
                }, {
                    toastMsg.postValue(it)
                }, {
                    exception.postValue(Throwable(it))
                })
            }
        } else {
            toastMsg.postValue("没有更多了")
        }
    }
}