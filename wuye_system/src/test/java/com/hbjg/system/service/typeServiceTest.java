package com.hbjg.system.service;

import com.hbjg.system.pojo.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class typeServiceTest {

    @Autowired
    private ITypeService iTypeService;

    @Test
    public void getAll(){
        List<Type> list = iTypeService.list();
        System.out.println(list);
    }
}
