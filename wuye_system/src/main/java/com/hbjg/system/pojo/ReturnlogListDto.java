package com.hbjg.system.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class ReturnlogListDto {


    @TableId(value = "id")
    private Integer id;
    private String returnee;
    private String propertyName;
    private String reviewer;
    private Integer propertyNumber;
    private String propertySpec;
    private Integer status;
    private Date time;
    private String imgSrc;
    private String remark;
}
