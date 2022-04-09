package com.hbjg.system.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Date;

@Data
public class Property {

    @TableId(value = "pid")
    private Integer pid;
    private String pname;
    private String spec;
    private Integer number;
    private Integer type;
    private Integer type2;
    private Integer storageitems;
    private String remark;
}
