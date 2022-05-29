package com.hbjg.system.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Purchaselog {

    @TableId(value = "id")
    private Integer id;
    private String userName;
    private String propertyName;
    private Integer propertyNumber;
    private String propertySpec;
    private Double propertyUnitprice;
    private Double propertySumprice;
    private Date time;
    private String remark;
}
