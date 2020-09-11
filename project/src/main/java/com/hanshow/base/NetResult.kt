package com.hanshow.base

sealed class NetResult<out T : Any> {

    data class Success<out T : Any>(val data: T, val msg: String) : NetResult<T>()
    data class Error(val exception: Exception) : NetResult<Nothing>()
    data class ErrorMsg(val errorMsg: String) : NetResult<Nothing>()
}