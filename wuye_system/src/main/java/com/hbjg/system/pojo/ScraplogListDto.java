package com.hbjg.system.pojo;


import lombok.Data;

import java.util.Date;

@Data
public class ScraplogListDto {

    private Integer id;
    private String userUsername;
    private String userName;
    private String propertyName;
    private String propertySpec;
    private Integer number;
    private Date time;
    private String remark;
}
