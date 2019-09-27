package com.hanshow.mine;

import io.reactivex.functions.Consumer;

public class MinePresenter extends MineContact.IMinePresenter {
    @Override
    public void getWelfare(int size, int page) {
        mRxManager.register(mIModel.getWelfare().subscribe(new Consumer<MineBean>() {
            @Override
            public void accept(MineBean mineBean) throws Exception {
                if (!mineBean.isError()) {
                    mIView.setWelfare(mineBean.getResults());
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        }));
    }

    @Override
    protected MineContact.IMineModel getModel() {
        return new MineModel();
    }

    @Override
    public void onStart() {
        getWelfare(20, 1);
    }
}
