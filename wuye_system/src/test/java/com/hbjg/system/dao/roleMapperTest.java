package com.hbjg.system.dao;

import com.hbjg.system.mapper.RoleMapper;
import com.hbjg.system.pojo.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class roleMapperTest {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void getAll(){
        List<Role> roles = roleMapper.selectList(null);
        System.out.println(roles);
    }
}
