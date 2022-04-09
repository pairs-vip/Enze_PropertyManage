package com.hbjg.system.service;


import com.hbjg.system.pojo.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@SpringBootTest
public class departmentServiceTest {

    @Autowired
    private IDepartmentService iDepartmentService;

    @Test
    public void getAll(){
        List<Department> list = iDepartmentService.list();
        System.out.println(list);
    }
}
