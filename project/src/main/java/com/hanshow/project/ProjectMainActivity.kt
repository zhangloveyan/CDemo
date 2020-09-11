package com.hanshow.project

import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.hanshow.base.BaseVMActivity
import com.hanshow.commonlib.constants.Page
import com.hanshow.project.databinding.ActivityProjectMainBinding


@Route(path = Page.PROJECT)
class ProjectMainActivity() : BaseVMActivity<ProjectModel, ActivityProjectMainBinding>(), ClickPresenter {

    private lateinit var adapter: ProjectAdapter

    override fun initData() {
        mViewModel.getProject()
    }

    override fun initView() {
        ARouter.getInstance().inject(this)
        mBinding.clickPresenter = this

        initRv()
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_project_main
    }

    override fun startObserve() {
        mViewModel.mLiveListProjectBean.observe(this, Observer {
            adapter.replace(it)
        })

        mViewModel.toastMsg.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }

    override fun initVM(): ProjectModel {
        return ViewModelProvider(this).get(ProjectModel::class.java)
    }

    private fun initRv() {
        adapter = ProjectAdapter(this)
        mBinding.rvProject.adapter = adapter
        mBinding.rvProject.layoutManager = LinearLayoutManager(this)

        adapter.mListener = object : RecyclerClickListener<DataX> {
            override fun onClick(bean: DataX, position: Int) {
                Toast.makeText(this@ProjectMainActivity, bean.link, Toast.LENGTH_SHORT).show()
            }

            override fun onLongClick(bean: DataX, position: Int) {
            }
        }
    }

    override fun onClick(v: View) {
        if (v.id == R.id.iv_back) {
            finish()
        }
    }
}
