package com.hanshow.project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hanshow.project.databinding.LayoutItemProjectBinding

class ProjectAdapter(context: Context, data: MutableList<DataX>) : RecyclerView.Adapter<ProjectAdapter.ViewHolder>() {

    private val mContext = context;
    private var mDataX = data;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val bind = DataBindingUtil.inflate<LayoutItemProjectBinding>(
                LayoutInflater.from(mContext),
                R.layout.layout_item_project,
                parent,
                false
        )

        return ViewHolder(bind.root, bind)
    }

    override fun getItemCount(): Int {
        return mDataX.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(mDataX[position], mContext)
    }


    class ViewHolder(itemView: View, binding: LayoutItemProjectBinding) : RecyclerView.ViewHolder(itemView) {
        private val mBinding = binding
        fun setData(dataX: DataX, mContext: Context) {
            mBinding.bean = dataX
        }
    }
}