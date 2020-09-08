package com.hanshow.project

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ProjectModel : ViewModel() {

    var mLiveListProjectBean = MutableLiveData<List<DataX>>()
    var projectRepository = ProjectRepository()

    fun getProject() {
        viewModelScope.launch {
            val projectBean = projectRepository.getProject(294)
            if (projectBean.errorCode == 0) {
                val data = projectBean.data.datas

                mLiveListProjectBean.postValue(data)
            } else {

            }
        }
    }
}

