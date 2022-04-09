package com.hbjg.system.controller.utils;

import lombok.Data;

@Data
public class R {
    private Boolean flag;
    private Object data;
    private String message;

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public R(Boolean flag, Object data, String message) {
        this.flag = flag;
        this.data = data;
        this.message = message;
    }

    @Override
    public String toString() {
        return "R{" +
                "flag=" + flag +
                ", data=" + data +
                '}';
    }

    public R(Boolean flag){
        this.flag = flag;
    }

    public R(){}

    public R(Boolean flag,Object data){
        this.flag=flag;
        this.data=data;
    }

    public R(String message){
        this.flag = false;
        this.message = message;
    }

    public R(Boolean flag,String message) {
        this.flag = flag;
        this.message = message;

    }
}
