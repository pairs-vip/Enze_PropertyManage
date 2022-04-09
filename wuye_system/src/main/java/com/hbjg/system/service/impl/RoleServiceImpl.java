package com.hbjg.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbjg.system.mapper.RoleMapper;
import com.hbjg.system.pojo.Role;
import com.hbjg.system.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper,Role> implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;

}
