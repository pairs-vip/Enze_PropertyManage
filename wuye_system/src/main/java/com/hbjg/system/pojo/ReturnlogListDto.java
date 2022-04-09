package com.hbjg.system.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Date;

@Data
public class ReturnlogListDto {


    @TableId(value = "rlid")
    private Integer rlid;
    private String sname;
    private String guihuanren;
    private String pname;
    private String tongyiren;
    private Integer number;
    private String status;
    private Date time;
    private String imgSrc;
    private String remark;
}
