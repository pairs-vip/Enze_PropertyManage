package com.hbjg.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hbjg.system.pojo.User;
import com.hbjg.system.pojo.UserListDto;

import java.util.List;

public interface IUserService extends IService<User> {

    User getUserByUsernameAndPwd(String username,String password);

    User getAdminByUsernameAndPwd(String username,String password);

    User getByUsername(String username);

    IPage<User> getByPage(Integer currentPage,Integer pageSize);

    List<User> queryList();

    IPage<UserListDto> getUserMyPage(Integer currentPage,Integer pageSize,User user);

    Boolean updateRole(Integer uid, Integer rid);

}
