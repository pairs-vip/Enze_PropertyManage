package com.hbjg.system.service;


import com.hbjg.system.pojo.Condition;
import com.hbjg.system.pojo.DeliverylogListDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DeliverylogServiceTest {

    @Autowired
    private IDeliverylogService iDeliverylogService;

    @Test
    public void selectallmypage(){

        Condition condition = new Condition();;
        iDeliverylogService.selectDlogMyPage(2,1,condition);
    }
}
