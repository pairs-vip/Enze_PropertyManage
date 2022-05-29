package com.hbjg.system.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Backlog {

    @TableId(value = "id")
    private Integer id;
    private String userName;
    private String propertyName;
    private Integer propertyNumber;
    private String propertySpec;
    private String propertyUnitprice;
    private String propertySumprice;
    private Date time;
    private String remark;
}
