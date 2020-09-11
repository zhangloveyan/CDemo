package com.hanshow.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

    val exception: MutableLiveData<Throwable> = MutableLiveData()
    val toastMsg: MutableLiveData<String> = MutableLiveData()
    val needLogin: MutableLiveData<Boolean> = MutableLiveData()

    open class UiState(
            /**
             * 加载框
             */
            val showLoading: Boolean = false,
            /**
             * 无数据
             */
            val showNull: Boolean = false
    )

    open class RvState(
            /**
             * 上拉刷新
             */
            var isRefresh: Boolean = false,
            /**
             * 下拉加载
             */
            var isMore: Boolean = false,
            /**
             * 没有更多了
             */
            var isEnd: Boolean = false
    )

    fun <T : Any> NetResult<T>.checkResult(success: (T) -> Unit,
                                           error: ((String) -> Unit)? = null,
                                           exception: ((Exception) -> Unit)? = null) {
        when (this) {
            is NetResult.Success -> {
                success(this.data)
            }
            is NetResult.ErrorMsg -> {
                error?.let { it(this.errorMsg) }
            }
            is NetResult.Error -> {
                exception?.let { it(this.exception) }
            }
        }
    }
}