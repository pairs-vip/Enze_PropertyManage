package com.hbjg.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbjg.system.mapper.UserMapper;
import com.hbjg.system.pojo.User;
import com.hbjg.system.pojo.UserListDto;
import com.hbjg.system.service.IUserService;
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
    public User getAdminByUsernameAndPwd(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tb_user.username",username);
        queryWrapper.eq("tb_user.password",password);
        queryWrapper.in("tb_user.role_id","1","2","3");
        User user = userMapper.findUserByUsernameAndPwdAndRole(queryWrapper);
        return user;
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

    //查所有
    @Override
    public List<User> queryList() {
        return userMapper.selectList(null);
    }

    @Override
    public IPage<UserListDto> getUserMyPage(Integer currentPage,Integer pageSize, User user){

        //将条件封装到QueryWrapper中
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        if(user.getRoleId()!=null) {
            queryWrapper.like("tb_user.role_id", user.getRoleId());
        }
        if(user.getDepartmentId()!=null) {
            queryWrapper.like("tb_user.department_id", user.getDepartmentId());
        }
        IPage<UserListDto> page = new Page(currentPage,pageSize);
        page = userMapper.selectUserMyPage(page, queryWrapper);
        return page;
    }

    //根据id修改职位
    @Override
    public Boolean updateRole(Integer uid, Integer rid) {
       return userMapper.updateRole(uid,rid);
    }

    //通过职位筛选用户
    @Override
    public List<User> selectByRole(Integer rid) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.eq("tb_user.role_id",rid);
        return userMapper.selectList(queryWrapper);
    }


}
