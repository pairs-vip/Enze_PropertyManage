package com.hbjg.system.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Role {

    @TableId(value = "id")
    private Integer id;
    private String name;
    private String power;
    private String description;

}
