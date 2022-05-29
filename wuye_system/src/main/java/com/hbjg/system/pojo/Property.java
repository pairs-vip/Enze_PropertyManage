package com.hbjg.system.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Date;

@Data
public class Property {

    @TableId(value = "id")
    private Integer id;
    private String name;
    private String spec;
    private Integer number;
    private Integer typeId;
    private Integer type2Id;
    private Integer storageitemsId;
    private String remark;
}
