package com.hbjg.system.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class ReturnlogListDto {


    @TableId(value = "rlid")
    private Integer rlid;
    private String returnee;
    private String pname;
    private String reviewer;
    private Integer number;
    private String spec;
    private String status;
    private Date time;
    private String imgSrc;
    private String remark;
}
