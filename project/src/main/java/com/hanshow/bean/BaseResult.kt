package com.hanshow.bean

/**
 * @author Zz 张立男
 * @Description 自定义的通用的网络数据封装类
 * @date 2020/9/10 16:49
 * o(＞﹏＜)o
 */
class BaseResult<T>(val code: Int, val message: String, val data: T)