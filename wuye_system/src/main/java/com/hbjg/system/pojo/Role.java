package com.hbjg.system.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Role {

    @TableId(value = "rid")
    private Integer rid;
    private String rname;
    private String power;
    private String description;

}
