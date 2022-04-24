package com.hbjg.system.pojo;


import lombok.Data;

import java.util.Date;

@Data
public class Scraplog {

    private Integer id;
    private Integer userId;
    private Integer propertyId;
    private Integer number;
    private Date time;
    private String remark;
}
