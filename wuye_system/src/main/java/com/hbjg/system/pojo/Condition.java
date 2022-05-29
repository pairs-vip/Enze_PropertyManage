package com.hbjg.system.pojo;


import lombok.Data;

@Data
public class Condition {

    private String propertyName;
    private Integer userId;
    private Integer status;
    private String begin;
    private String end;
}
