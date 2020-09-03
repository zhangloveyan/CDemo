package com.hanshow.project

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.hanshow.commonlib.constants.Page
import com.hanshow.project.databinding.ActivityProjectMainBinding

@Route(path = Page.PROJECT)
class ProjectMainActivity : AppCompatActivity(), ClickPresenter {

    private lateinit var mViewBinding: ActivityProjectMainBinding
    private lateinit var userBean: UserBean
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)

        mViewBinding = DataBindingUtil.setContentView(this, R.layout.activity_project_main)

        userBean = UserBean()
        userBean.userId = "213"
        userBean.userName = "守护"

        mViewBinding.user = userBean
    }


    override fun onClick(v: View?) {
        if (v != null) {
            if (v.id == R.id.tv_click) {
                userBean.userId = "321"
                userBean.userName = "哈哈"

                Toast.makeText(this, "点击", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
