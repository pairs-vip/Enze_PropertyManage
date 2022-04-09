package com.hbjg.system.pojo;


import lombok.Data;

import java.sql.Date;

@Data
public class Purchaselog {

    private Integer purchaselogId;
    private String userName;
    private String propertyName;
    private Integer propertyNumber;
    private String propertySpec;
    private Double propertyUnitprice;
    private Double propertySumprice;
    private Date purchaselogTime;
    private String purchaselogRemark;
}
