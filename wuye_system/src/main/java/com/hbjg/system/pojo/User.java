package com.hbjg.system.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;


@Data
public class User {

    @TableId(value = "uid")
    private Integer uid;
    private String username;
    private String password;
    private String name;
    private String phone;
    private Integer role;
    private Integer department;
    private Date joindate;

}
