package com.hbjg.system.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;


@Data
public class Lendlog {


    @TableId(value = "id")
    private Integer id;
    private Integer userId1;
    private Integer propertyId;
    private Integer userId2;
    private Integer propertyNumber;
    private Integer status;
    private Date time;
    private String imgSrc;
    private String remark;
}
