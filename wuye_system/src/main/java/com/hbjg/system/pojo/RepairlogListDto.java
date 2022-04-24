package com.hbjg.system.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class RepairlogListDto {


    private Integer id;
    //用户账号
    private String userUsername;
    //用户姓名
    private String userName;
    private String propertyName;
    private Integer number;
    //资产规格
    private String propertySpec;
    private Integer status;
    private Date time;
    private String remark;
}
