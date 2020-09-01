package com.hanshow.mine;

import io.reactivex.functions.Consumer;

public class MinePresenter extends MineContact.IMinePresenter {

    @Override
    protected MineContact.IMineModel getModel() {
        return new MineModel();
    }

    @Override
    public void onStart() {
    }

    @Override
    public void login(String userName, String password) {
        mRxManager.register(mIModel.login(userName, password).subscribe(new Consumer<MineBean>() {
            @Override
            public void accept(MineBean bean) throws Exception {
                if (bean.getErrorCode() == 0) {
                    mIView.login(bean.getData());
                } else {
                    mIView.showToast("登录失败");
                }
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        }));
    }
}
