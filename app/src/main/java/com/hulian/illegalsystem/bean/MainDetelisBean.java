package com.hulian.illegalsystem.bean;

/**
 * 作者：qgl 时间： 2020/9/18 14:20
 * Describe: 违章列表bean
 */
public class MainDetelisBean {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    private String id;
    private String msg;
    private String name;
    private String context;

}
