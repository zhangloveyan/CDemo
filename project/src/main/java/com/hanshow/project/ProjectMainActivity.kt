package com.hanshow.project

import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.hanshow.commonlib.constants.Page
import com.hanshow.project.databinding.ActivityProjectMainBinding


@Route(path = Page.PROJECT)
class ProjectMainActivity : AppCompatActivity(), ClickPresenter {

    private lateinit var mViewBinding: ActivityProjectMainBinding
    private lateinit var projectModel: ProjectModel
    private lateinit var adapter: ProjectAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)

        mViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_project_main)
        mViewBinding.clickPresenter = this

        projectModel = ViewModelProvider(this).get(ProjectModel::class.java)

        mViewBinding.rvProject.layoutManager = LinearLayoutManager(this)

        projectModel.mLiveListProjectBean.observe(this, Observer {
            adapter = ProjectAdapter(this, it)
            mViewBinding.rvProject.adapter = adapter
        })

        projectModel.getProject()
    }

    override fun onClick(v: View) {
        if (v.id == R.id.iv_back) {
            finish()
        }
    }
}
