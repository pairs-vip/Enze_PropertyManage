package com.hbjg.system.service;


import com.hbjg.system.pojo.Condition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReturnlogServiceTest {


    @Autowired
    private IReturnlogService iReturnlogService;

    @Test
    public void test01(){
        Condition condition = new Condition();
        iReturnlogService.getReturnlogMyPage(1,10,condition);
    }
}
