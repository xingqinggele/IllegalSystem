package com.hulian.illegalsystem.bean;

import java.io.Serializable;

/**
 * 作者：qgl 时间： 2020/9/18 13:48
 * Describe:违章数据存储
 */
public class IllegalBean implements Serializable {
    // 密钥
    private String appkey;
    //车牌前缀
    private String lsprefix;
    //车牌剩余部分
    private String lsnum;
    //车架号
    private String frameno;
    //发动机号
    private String engineno;
    //车辆类型
    private String lstype;
    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getLsprefix() {
        return lsprefix;
    }

    public void setLsprefix(String lsprefix) {
        this.lsprefix = lsprefix;
    }

    public String getLsnum() {
        return lsnum;
    }

    public void setLsnum(String lsnum) {
        this.lsnum = lsnum;
    }

    public String getFrameno() {
        return frameno;
    }

    public void setFrameno(String frameno) {
        this.frameno = frameno;
    }

    public String getEngineno() {
        return engineno;
    }

    public void setEngineno(String engineno) {
        this.engineno = engineno;
    }

    public String getLstype() {
        return lstype;
    }

    public void setLstype(String lstype) {
        this.lstype = lstype;
    }


}
