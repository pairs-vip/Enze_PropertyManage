package com.hbjg.system.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;


@Data
public class User {

    @TableId(value = "id")
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private Integer roleId;
    private Integer departmentId;
    private Date joindate;
    @TableField(exist = false)
    private String token;
    @TableField(exist = false)
    private String Avatar;

}
