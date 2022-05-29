package com.hbjg.system.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class UserListDto {

    @TableId(value = "id")
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String roleName;
    private String departmentName;
    private Date joindate;
}
