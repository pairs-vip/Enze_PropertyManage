package com.hbjg.system.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Type2 {

    @TableId(value = "id")
    private Integer id;
    private Integer typeId;
    private String name;
}
