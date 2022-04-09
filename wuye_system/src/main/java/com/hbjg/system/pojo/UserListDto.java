package com.hbjg.system.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Date;

@Data
public class UserListDto {

    @TableId(value = "uid")
    private Integer uid;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String rname;
    private String dname;
    private Date joindate;
}
