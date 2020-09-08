package com.hanshow.project

interface RecyclerClickListener<T> {
    fun onClick(bean: T, position: Int)
    fun onLongClick(bean: T, position: Int)
}