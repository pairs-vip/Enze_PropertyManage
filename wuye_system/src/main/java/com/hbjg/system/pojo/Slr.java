package com.hbjg.system.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Slr {

    @TableId(value = "slrid")
    private Integer slrid;
    private Integer uid;
    private Integer pid;
    private Integer number;
}
