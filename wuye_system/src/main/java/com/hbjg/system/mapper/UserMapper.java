package com.hbjg.system.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.hbjg.system.pojo.User;
import com.hbjg.system.pojo.UserListDto;
import org.apache.ibatis.annotations.*;
import java.util.List;


@Mapper
public interface UserMapper extends MyBaseMapper<User> {

    //查询所有用户
    IPage<UserListDto> selectUserMyPage(IPage<UserListDto> page, @Param(Constants.WRAPPER) QueryWrapper<User> queryWrapper);

    //更改职位
    Boolean updateRole(Integer uid, Integer rid);

    //通过用户名密码和职位查找用户
    User findUserByUsernameAndPwdAndRole(@Param(Constants.WRAPPER) QueryWrapper<User> queryWrapper);

    //查看所有以数据库中的格式返回
    List<User> findAll();

    //通过id查找用户
    User findById(Integer id);
}

