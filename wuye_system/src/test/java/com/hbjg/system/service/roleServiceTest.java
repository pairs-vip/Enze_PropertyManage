package com.hbjg.system.service;

import com.hbjg.system.pojo.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class roleServiceTest {

    @Autowired
    private IRoleService iRoleService;

    @Test
    public void getAll(){
        List<Role> list = iRoleService.list();
        System.out.println(list);
    }
}
