package com.hanshow.mine;

import com.hanshow.commonlib.base.BasePresenter;
import com.hanshow.commonlib.base.IModel;
import com.hanshow.commonlib.base.IView;

import io.reactivex.Observable;

public interface MineContact {
    interface IMineModel extends IModel {
        /**
         * 列表
         *
         * @return
         */
        Observable<MineBean> login(String userName, String password);
    }

    interface IMineView extends IView {

        void login(MineBean.DataBean data);
    }

    abstract class IMinePresenter extends BasePresenter<IMineModel, IMineView> {

        /**
         * 首页列表
         *
         * @return
         */
        public abstract void login(String userName, String password);

    }
}
