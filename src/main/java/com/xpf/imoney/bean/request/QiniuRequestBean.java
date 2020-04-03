package com.xpf.imoney.bean.request;

import java.io.Serializable;

/**
 * Created by Vance on 2020/4/3 :)
 * Function:
 */
public class QiniuRequestBean implements Serializable {

    private String accessKey;
    private String secretKey;
    private String bucket;

    public QiniuRequestBean() {
    }

    public QiniuRequestBean(String accessKey, String secretKey, String bucket) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
        this.bucket = bucket;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    @Override
    public String toString() {
        return "QiniuRequestBean{" +
                "accessKey='" + accessKey + '\'' +
                ", secretKey='" + secretKey + '\'' +
                ", bucket='" + bucket + '\'' +
                '}';
    }
}
