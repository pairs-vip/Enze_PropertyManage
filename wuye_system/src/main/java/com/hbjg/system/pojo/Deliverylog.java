package com.hbjg.system.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Deliverylog {

    @TableId(value = "dlid")
    private Integer dlid;
    private Integer name;
    private String pname;
    private String spec;
    private Integer number;
    private String type;
    private String type2;
    private Date deliveryDate;
    private String imgSrc;
    private String remark;
}
