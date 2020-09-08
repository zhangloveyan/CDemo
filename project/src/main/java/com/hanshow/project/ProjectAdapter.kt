package com.hanshow.project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hanshow.project.databinding.LayoutItemProjectBinding

class ProjectAdapter(context: Context) : RecyclerView.Adapter<ProjectAdapter.ViewHolder>() {

    private val mContext = context
    private var mDataX: ArrayList<DataX> = ArrayList()
    lateinit var mListener: RecyclerClickListener<DataX>

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
        holder.mBinding.bean = mDataX[position]
        holder.mBinding.root.setOnClickListener(View.OnClickListener {
            mListener.onClick(mDataX[position], position)
        })
    }

    fun replace(list: List<DataX>) {
        mDataX.clear()
        mDataX.addAll(list)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View, binding: LayoutItemProjectBinding) : RecyclerView.ViewHolder(itemView) {
        internal val mBinding = binding
    }
}