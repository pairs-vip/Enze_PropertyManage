package com.hbjg.system.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Slr {

    @TableId(value = "id")
    private Integer id;
    private Integer userId;
    private Integer propertyId;
    private Integer propertyNumber;
}
