package com.hanshow.project

import android.view.View

interface ClickPresenter : View.OnClickListener {
    override fun onClick(v: View?)
}