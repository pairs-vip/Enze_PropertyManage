package com.hbjg.system.pojo;

import lombok.Data;

import java.sql.Date;

@Data
public class PropertyListDto {

    private Integer id;
    private String name;
    private String spec;
    private Integer number;
    private String typeName;
    private String type2Name;
    private String storageitemsName;
    private String remark;
}
