package com.hbjg.system.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("tb_officalwebsite")
@Data
public class OfficalWeb {

    @TableId
    private Integer id;
    private String title;
    private String content;
    private String imgSrc;
}
