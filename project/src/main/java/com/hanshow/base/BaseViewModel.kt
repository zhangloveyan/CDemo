package com.hanshow.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hanshow.bean.NetResult

open class BaseViewModel : ViewModel() {

    val exception: MutableLiveData<Throwable> = MutableLiveData()
    val toastMsg: MutableLiveData<String> = MutableLiveData()
    val needLogin: MutableLiveData<Boolean> = MutableLiveData()

    /**
     * 上拉刷新是否完成
     */
    val refreshComplete: MutableLiveData<Boolean> = MutableLiveData()


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

    open class DataList<T>(
            var isRefresh: Boolean = false,
            var list: List<T> = ArrayList()
    )
}