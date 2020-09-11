package com.hanshow.project

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hanshow.base.BaseViewModel
import kotlinx.coroutines.launch

class ProjectModel : BaseViewModel() {

    var mLiveListProjectBean = MutableLiveData<List<DataX>>()
    private var projectRepository = ProjectRepository()

    fun getProject() {
        viewModelScope.launch {
            val result = projectRepository.getProject(294)

            result.checkResult({
                mLiveListProjectBean.postValue(it.datas)
            }, {
                toastMsg.postValue(it)
            }, {
                exception.postValue(Throwable(it))
            })
        }
    }
}

