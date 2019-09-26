package com.hanshow.commonlib.base;

/**
 * @author Zz 张立男
 * @Description RequestBean 请求基类
 * @date 2019/9/26 15:09
 * o(＞﹏＜)o
 */
public class RequestBean<T> {

    /**
     * merchantId : 1
     * clientType : 21
     * deviceNum : 1
     * requestId : c8dfa83f-3f2d-4836-8443-bec755251cdf
     * securityKey : a3ce4b41c63045998fffcfcd705c7766-1564554448678
     * storeId : 19
     * timestamp : 1564554313823
     * userId : 249
     * data : {"deviceCode":"200119090000000775"}
     */

    private String merchantId;
    private String clientType;
    private String deviceNum;
    private String requestId;
    private String securityKey;
    private String storeId;
    private String timestamp;
    private String userId;
    private T data;

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getDeviceNum() {
        return deviceNum;
    }

    public void setDeviceNum(String deviceNum) {
        this.deviceNum = deviceNum;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getSecurityKey() {
        return securityKey;
    }

    public void setSecurityKey(String securityKey) {
        this.securityKey = securityKey;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
