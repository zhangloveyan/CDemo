package com.hanshow.home;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.HomeListHolder> {
    private List<HomeListBean.DatasBean> mList;
    private Context mContext;

    public HomeListAdapter(List<HomeListBean.DatasBean> list, Context context) {
        mList = list;
        mContext = context.getApplicationContext();
    }

    @NonNull
    @Override
    public HomeListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_list, null, false);
        return new HomeListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeListHolder holder, int position) {
        HomeListBean.DatasBean bean = mList.get(position);

        holder.mTvTitle.setText(bean.getTitle());
        String desc = bean.getDesc();
        if (TextUtils.isEmpty(desc)) {
            holder.mTvDesc.setText("暂无简介");
        } else {
            holder.mTvDesc.setText(desc);
        }
    }

    @Override
    public int getItemCount() {
        if (mList == null || mList.isEmpty()) {
            return 0;
        }
        return mList.size();
    }

    class HomeListHolder extends RecyclerView.ViewHolder {

        private final TextView mTvTitle;
        private final TextView mTvDesc;

        public HomeListHolder(@NonNull View itemView) {
            super(itemView);
            mTvTitle = itemView.findViewById(R.id.tv_item_home_list_title);
            mTvDesc = itemView.findViewById(R.id.tv_item_home_list_desc);
        }
    }

    public void refreshRv(List<HomeListBean.DatasBean> list) {
        mList = list;
        notifyDataSetChanged();
    }
}
