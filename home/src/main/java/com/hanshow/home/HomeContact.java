package com.hanshow.home;

import com.hanshow.commonlib.base.BasePresenter;
import com.hanshow.commonlib.base.IModel;
import com.hanshow.commonlib.base.IView;
import com.hanshow.commonlib.base.ResultBean;

import java.util.List;

import io.reactivex.Observable;

public interface HomeContact {
    interface IHomeModel extends IModel {
        /**
         * 获取banner数据
         *
         * @return
         */
        Observable<ResultBean<List<HomeBannerBean>>> getHomeBanner();

        /**
         * 首页列表
         *
         * @param page
         * @return
         */
        Observable<ResultBean<HomeListBean>> getHomeList(int page);
    }

    interface IHomeView extends IView {

        void setBanner(List<HomeBannerBean> bannerBean);

        void setList(HomeListBean listBean);
    }

    abstract class IHomePresenter extends BasePresenter<IHomeModel, IHomeView> {

        /**
         * 获取banner数据
         *
         * @return
         */
        public abstract void getHomeBanner();

        /**
         * 首页列表
         *
         * @param page
         * @return
         */
        public abstract void getHomeList(int page);

    }
}
