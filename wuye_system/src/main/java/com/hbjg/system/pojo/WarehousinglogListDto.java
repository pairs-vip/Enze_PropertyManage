package com.hbjg.system.pojo;


import lombok.Data;

import java.sql.Date;

@Data
public class WarehousinglogListDto {

    private Integer wlid;
    private String name;
    private String pname;
    private String spec;
    private Integer number;
    private String type;
    private String type2;
    private Date warehousingDate;
    private String imgSrc;
    private String remark;
}
