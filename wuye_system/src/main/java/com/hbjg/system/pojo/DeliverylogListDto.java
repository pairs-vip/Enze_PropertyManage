package com.hbjg.system.pojo;

import lombok.Data;

import java.sql.Date;


@Data
public class DeliverylogListDto {

    private Integer dlid;
    private String name;
    private String pname;
    private String spec;
    private Integer number;
    private String type;
    private String type2;
    private Date deliveryDate;
    private String imgSrc;
    private String remark;
}
