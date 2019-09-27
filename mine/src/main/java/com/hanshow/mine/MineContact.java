package com.hanshow.mine;

import com.hanshow.commonlib.base.BasePresenter;
import com.hanshow.commonlib.base.IModel;
import com.hanshow.commonlib.base.IView;

import java.util.List;

import io.reactivex.Observable;

public interface MineContact {
    interface IMineModel extends IModel {
        /**
         * 列表
         *
         * @return
         */
        Observable<MineBean> getWelfare();
    }

    interface IMineView extends IView {

        void setWelfare(List<MineBean.ResultsBean> results);
    }

    abstract class IMinePresenter extends BasePresenter<IMineModel, IMineView> {

        /**
         * 首页列表
         *
         * @return
         */
        public abstract void getWelfare(int size, int page);

    }
}
