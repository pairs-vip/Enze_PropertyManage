package com.hbjg.system.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Operationlog {

    @TableId(value = "id")
    private Integer id;
    private String userUsername;
    private String userName;
    private String operationObj;
    private String operationType;
    private Date operationTime;

    @TableField(exist = false)
    private String operationTime1;
    @TableField(exist = false)
    private String operationTime2;
}
