package com.hbjg.system.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
public class Storageitems {

    @TableId(value = "sid")
    private Integer sid;
    private String sname;
}
