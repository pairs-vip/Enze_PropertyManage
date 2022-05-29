package com.hbjg.system.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Type {

    @TableId(value = "id")
    private Integer id;
    private String name;
}
