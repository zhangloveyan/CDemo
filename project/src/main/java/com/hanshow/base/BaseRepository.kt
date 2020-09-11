package com.hanshow.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope

/**
 * @author Zz 张立男
 * @Description 通用的网络请求处理
 * @date 2020/9/10 16:49
 * o(＞﹏＜)o
 */
open class BaseRepository {
    suspend fun <T : Any> callRequest(
            call: suspend () -> NetResult<T>
    ): NetResult<T> {
        return try {
            call()
        } catch (e: Exception) {
            e.printStackTrace()
            NetResult.Error(e)
        }
    }

    suspend fun <T : Any> execRequest(
            response: BaseResult<T>,
            successBlock: (suspend CoroutineScope.() -> Unit)? = null,
            errorBlock: (suspend CoroutineScope.() -> Unit)? = null
    ): NetResult<T> {
        return coroutineScope {
            if (response.code == 0) {
                successBlock?.let { it() }
                NetResult.Success(response.data, response.message)
            } else {
                errorBlock?.let { it() }
                NetResult.ErrorMsg(response.message)
            }
        }
    }
}