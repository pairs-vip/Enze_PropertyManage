package com.hbjg.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbjg.system.mapper.UserMapper;
import com.hbjg.system.pojo.User;
import com.hbjg.system.pojo.UserListDto;
import com.hbjg.system.service.IUserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUsernameAndPwd(String username, String password) {
        return userMapper.findUserByUsernameAndPwd(username,password);
    }

    @Override
    public User getByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public IPage<User> getByPage(Integer currentPage, Integer pageSize) {
        IPage<User> page = new Page<>(currentPage,pageSize);
        page = userMapper.selectPage(page, null);
        return page;
    }

    @Override
    public List<User> queryList() {
        return userMapper.selectList(null);
    }

    @Override
    public IPage<UserListDto> getUserMyPage(Integer currentPage,Integer pageSize, User user){

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        if(Strings.isNotEmpty(user.getUsername())) {
            queryWrapper.like("tb_user.username", user.getUsername());
        }
        if(Strings.isNotEmpty(user.getName())) {
            queryWrapper.like("tb_user.name", user.getName());
        }
        if(Strings.isNotEmpty(user.getPhone())) {
            queryWrapper.like("tb_user.phone", user.getPhone());
        }

//        lqw.like(Strings.isNotEmpty(user.getUsername()),User::getUsername,user.getUsername());
//        lqw.like(Strings.isNotEmpty(user.getPhone()),User::getPhone,user.getPhone());
//        lqw.like(Strings.isNotEmpty(user.getName()),User::getName,user.getName());
        IPage<UserListDto> page = new Page(currentPage,pageSize);
        page = userMapper.selectUserMyPage(page, queryWrapper);
        return page;
    }

    @Override
    public Boolean updateRole(Integer uid, Integer rid) {
       return userMapper.updateRole(uid,rid);
    }


}
