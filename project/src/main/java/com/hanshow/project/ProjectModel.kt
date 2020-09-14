package com.hanshow.project

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hanshow.base.BaseViewModel
import kotlinx.coroutines.launch
import java.util.*

class ProjectModel : BaseViewModel() {

    var mLiveListProjectBean = MutableLiveData<List<DataX>>()
    private var projectRepository = ProjectRepository()
    private val total = 4
    var currentPage = 1
    private var currentList = ArrayList<DataX>()

    fun getProject(page: Int) {

        if (page == 1) {
            currentPage = 1
            currentList.clear()
        }

        if (currentPage <= total) {
            viewModelScope.launch {
                val result = projectRepository.getProject(currentPage, 294)

                result.checkResult({
                    currentPage++
                    currentList.addAll(it.datas)

                    mLiveListProjectBean.postValue(currentList)
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