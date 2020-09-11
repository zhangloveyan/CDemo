package com.hanshow.base

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseVMActivity<VM : BaseViewModel, D : ViewDataBinding> : AppCompatActivity() {
    lateinit var mBinding: D
    lateinit var mViewModel: VM
    override fun onCreate(savedInstanceState: Bundle?) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)

        mViewModel = initVM()
        startObserve()

        mBinding = DataBindingUtil.setContentView(this, getLayoutResId())
        mBinding.lifecycleOwner = this

        initView()
        initData()
    }

    abstract fun initData()

    abstract fun initView()

    abstract fun getLayoutResId(): Int

    abstract fun startObserve()

    abstract fun initVM(): VM
}