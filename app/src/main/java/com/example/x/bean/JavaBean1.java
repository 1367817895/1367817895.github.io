package com.example.x.bean;

import java.util.ArrayList;

/**
 * @Auther: 刘青松
 * @Date: 2019/1/21 08:53:06
 * @Description:
 */
public class JavaBean1 {
 private ArrayList<JavaBean> data;
 private String info;
 private Integer status;

    public ArrayList<JavaBean> getData() {
        return data;
    }

    public void setData(ArrayList<JavaBean> data) {
        this.data = data;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public JavaBean1(ArrayList<JavaBean> data, String info, Integer status) {
        this.data = data;
        this.info = info;
        this.status = status;
    }
    //   ": "获取内容成功",
//            ""
}
