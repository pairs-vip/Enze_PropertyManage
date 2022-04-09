package com.hbjg.system.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class type2ServiceTest {

    @Autowired
    private IType2Service iType2Service;

    @Test
    public void getall(){
        iType2Service.list();
    }

    @Test
    public void getType2byType(){
        iType2Service.getType2ByType(2);
    }
}
