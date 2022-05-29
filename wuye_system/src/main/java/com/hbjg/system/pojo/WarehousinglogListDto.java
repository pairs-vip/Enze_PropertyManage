package com.hbjg.system.pojo;


import lombok.Data;

import java.util.Date;

@Data
public class WarehousinglogListDto {

    private Integer id;
    private String userName;
    private String propertyName;
    private String propertySpec;
    private Integer propertyNumber;
    private String typeName;
    private String type2Name;
    private Date time;
    private String imgSrc;
    private String remark;
}
