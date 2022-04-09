package com.hbjg.system.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Type2 {

    @TableId(value = "t2id")
    private Integer t2id;
    private Integer tid;
    private String t2name;
}
