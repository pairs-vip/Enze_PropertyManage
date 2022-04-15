package com.hbjg.system.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class Returnlog {


    @TableId(value = "rlid")
    private Integer rlid;
    private Integer uid1;
    private Integer pid;
    private Integer uid2;
    private Integer number;
    private String status;
    private Date time;
    private String imgSrc;
    private String remark;
}