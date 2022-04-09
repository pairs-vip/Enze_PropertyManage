package com.hbjg.system.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Date;

@Data
public class Deliverylog {

    @TableId(value = "dlid")
    private Integer dlid;
    private Integer name;
    private Integer pname;
    private String spec;
    private Integer number;
    private String type;
    private String type2;
    private Date deliveryDate;
    private String imgSrc;
    private String remark;
}
