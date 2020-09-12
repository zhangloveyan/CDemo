package com.hanshow.bean

data class ResponseResult(
        val showLoading: Boolean = false,
        val showNetError: Boolean = false,
        val needLogin: Boolean = false,
        val showToast: String? = ""
)