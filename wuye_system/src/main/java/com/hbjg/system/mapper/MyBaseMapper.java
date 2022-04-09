package com.hbjg.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hbjg.system.pojo.User;

public interface MyBaseMapper<T> extends BaseMapper<T> {

    User findUserByUsernameAndPwd(String username,String password);

    User findUserByUsername(String username);
}
