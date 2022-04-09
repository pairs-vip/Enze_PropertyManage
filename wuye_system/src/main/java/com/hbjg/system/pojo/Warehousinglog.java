package com.hbjg.system.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Date;

@Data
public class Warehousinglog {

    @TableId(value = "wlid")
    private Integer wlid;
    private Integer name;
    private Integer pname;
    private String spec;
    private Integer number;
    private Integer type;
    private Integer type2;
    private Date warehousingDate;
    private String imgSrc;
    private String remark;
}
