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

        initRv()

        projectModel.mLiveListProjectBean.observe(this, Observer {
            adapter.replace(it)
        })

        projectModel.toastMsg.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
        projectModel.getProject()
    }

    private fun initRv() {
        adapter = ProjectAdapter(this)
        mViewBinding.rvProject.adapter = adapter
        mViewBinding.rvProject.layoutManager = LinearLayoutManager(this)

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
