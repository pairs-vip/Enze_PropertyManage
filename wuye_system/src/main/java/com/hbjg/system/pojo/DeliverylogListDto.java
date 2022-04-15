package com.hbjg.system.pojo;

import lombok.Data;

import java.util.Date;


@Data
public class DeliverylogListDto {

    private Integer dlid;
    private String name;
    private String pname;
    private String spec;
    private Integer number;
    private String tname;
    private String t2name;
    private Date deliveryDate;
    private String imgSrc;
    private String remark;
}
