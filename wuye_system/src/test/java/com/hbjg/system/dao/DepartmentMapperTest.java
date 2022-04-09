package com.hbjg.system.dao;

import com.hbjg.system.mapper.DepartmentMapper;
import com.hbjg.system.pojo.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DepartmentMapperTest {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Test
    public void getALl(){
        List<Department> departments = departmentMapper.selectList(null);
        System.out.println(departments);
    }
}
