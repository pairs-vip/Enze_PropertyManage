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
    private String tname;
    private String t2name;
    private Date warehousingDate;
    private String imgSrc;
    private String remark;
}
