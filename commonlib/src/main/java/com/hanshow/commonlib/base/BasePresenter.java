package com.hanshow.commonlib.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zz.mvp.base.BaseMvpPresenter;

import java.util.UUID;



/**
 * @author Zz 张立男
 * @Description BasePresenter 业务基础类
 * @date 2019/9/26 15:09
 * o(＞﹏＜)o
 */
public abstract class BasePresenter<M extends IModel, V extends IView> extends BaseMvpPresenter<M, V> {

    private String clientType = "21";
    private String deviceNum = "1";
    private String requestId = UUID.randomUUID().toString().replaceAll("-", "");
    private String timestamp = String.valueOf(System.currentTimeMillis());

    public Gson mGson;

    public static final String SUC = "SUC";

    public BasePresenter() {
        mGson = new GsonBuilder().serializeNulls().create();
    }

    /**
     * 获取请求封装类
     *
     * @param data
     * @param <T>
     * @return
     */
    public <T> RequestBean<T> getRequestBean(T data) {

        RequestBean<T> requestBean = new RequestBean<>();
//        requestBean.setMerchantId(SpUtils.getString(BaseApplication.getApplication(), Constants.Login.MERCHANT_ID, ""));
//        requestBean.setClientType(clientType);
//        requestBean.setDeviceNum(deviceNum);
//        requestBean.setRequestId(requestId);
//        requestBean.setSecurityKey(SpUtils.getString(BaseApplication.getApplication(), Constants.Login.SECURITY_KEY, ""));
//        requestBean.setStoreId(SpUtils.getString(BaseApplication.getApplication(), Constants.Login.STORE_ID, ""));
//        requestBean.setTimestamp(timestamp);
//        requestBean.setUserId(SpUtils.getString(BaseApplication.getApplication(), Constants.Login.USER_ID, ""));

        requestBean.setData(data);
        return requestBean;
    }

    public String beanToJson(RequestBean requestBean) {
        return mGson.toJson(requestBean);

    }

//    public RequestBody jsonToRequestBody(String json) {
//        return jsonToRequestBody(json, "application/json");
//    }
//
//    public RequestBody jsonToRequestBody(String json, String mediaType) {
//        return RequestBody.create(MediaType.parse(mediaType), json);
//    }
//
//    public <T> RequestBody beanToRequestBody(T data) {
//        return jsonToRequestBody(beanToJson(getRequestBean(data)));
//    }
}
