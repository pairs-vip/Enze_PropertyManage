package com.hbjg.system.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hbjg.system.pojo.LendlogListDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LendlogServiceTest {

    @Autowired
    private ILendlogService iLendlogService;

    @Test
    public void test001(){

        IPage<LendlogListDto> lendlogMyPage = iLendlogService.getLendlogMyPage(1, 1, null);
        System.out.println(lendlogMyPage);

    }
}
