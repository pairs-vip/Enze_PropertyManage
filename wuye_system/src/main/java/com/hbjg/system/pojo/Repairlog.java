package com.hbjg.system.pojo;


import lombok.Data;

import java.util.Date;

@Data
public class Repairlog {

    private Integer id;
    private Integer userId;
    private Integer propertyId;
    private Integer number;
    private Integer status;
    private Date time;
    private String remark;
}
