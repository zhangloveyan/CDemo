package com.hanshow.home;

public class HomePresenter extends HomeContact.IHomePresenter {
    @Override
    public void getHomeBanner() {

    }

    @Override
    public void getHomeList(int page) {

    }

    @Override
    protected HomeContact.IHomeModel getModel() {
        return new HomeModel();
    }

    @Override
    public void onStart() {

    }
}
