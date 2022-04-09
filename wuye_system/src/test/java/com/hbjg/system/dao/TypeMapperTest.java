package com.hbjg.system.dao;

import com.hbjg.system.mapper.TypeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TypeMapperTest {


    @Autowired
    private TypeMapper typeMapper;

    @Test
    public void getAll(){
        typeMapper.selectList(null);
    }
}
