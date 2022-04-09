package com.hbjg.system.service;


import com.hbjg.system.pojo.SlrListDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class slrServiceTest {

    @Autowired
    private ISlrService iSlrService;

    @Test
    public void test01(){
        List<SlrListDto> slrListDtos = iSlrService.selectAll();
        System.out.println(slrListDtos);
    }
}
