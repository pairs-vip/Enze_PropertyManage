package com.hbjg.system.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Department {

    @TableId(value="did")
    private Integer did;
    private String dname;
    private String description;
}
