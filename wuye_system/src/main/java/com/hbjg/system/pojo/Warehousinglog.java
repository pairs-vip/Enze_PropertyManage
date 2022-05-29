package com.hbjg.system.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Warehousinglog {

    @TableId(value = "id")
    private Integer id;
    private Integer userId;
    private String propertyName;
    private String propertySpec;
    private Integer propertyNumber;
    private Integer typeId;
    private Integer type2Id;
    private Date time;
    private String imgSrc;
    private String remark;
}
