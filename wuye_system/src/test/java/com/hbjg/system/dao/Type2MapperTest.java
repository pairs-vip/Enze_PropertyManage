package com.hbjg.system.dao;


import com.hbjg.system.mapper.Type2Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Type2MapperTest {

    @Autowired
    private Type2Mapper type2Mapper;

    @Test
    public void getall(){
        type2Mapper.selectList(null);
    }

    @Test
    public void getByTid(){
        type2Mapper.getT2ByT(1);
    }
}
