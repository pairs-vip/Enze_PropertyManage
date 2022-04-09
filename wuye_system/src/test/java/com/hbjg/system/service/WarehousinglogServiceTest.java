package com.hbjg.system.service;


import com.hbjg.system.pojo.WarehousinglogListDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WarehousinglogServiceTest {

    @Autowired
    private IWarehousinglogService iWarehousinglogService;

    @Test
    public void test01(){
        iWarehousinglogService.selectWlogMyPage(1,10,null);
    }
}
