package com.hbjg.system.pojo;


import lombok.Data;

@Data
public class Condition {

    private String propertyName;
    private Integer userId;
    private String status;
    private String begin;
    private String end;
}
