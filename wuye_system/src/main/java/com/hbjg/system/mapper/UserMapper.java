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
    //@Select("select tb_user.uid,tb_user.username,tb_user.PASSWORD,tb_user.NAME,tb_user.phone,tb_role.rname,tb_department.dname,tb_user.joindate from tb_user,tb_role,tb_department where tb_user.role = tb_role.rid  AND tb_user.department = tb_department.did;")
    //List<User> selectList(@Param(Constants.WRAPPER) Wrapper<UserListDto> queryWrapper);
    IPage<UserListDto> selectUserMyPage(IPage<UserListDto> page, @Param(Constants.WRAPPER) QueryWrapper<User> queryWrapper);


    Boolean updateRole(Integer uid, Integer rid);

    User findUserByUsernameAndPwdAndRole(@Param(Constants.WRAPPER) QueryWrapper<User> queryWrapper);

    List<User> findAll();

    User findById(Integer id);
}

