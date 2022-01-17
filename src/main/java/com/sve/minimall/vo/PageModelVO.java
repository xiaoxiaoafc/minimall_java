package com.sve.minimall.vo;


import java.util.List;

/**
 * 分页返回模型
 * @param <T>
 */
public class PageModelVO<T> {
    private List<T> data;
    private String status;
    private String message;
    public PageModelVO(){

    }

    public PageModelVO(List<T> data){
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
