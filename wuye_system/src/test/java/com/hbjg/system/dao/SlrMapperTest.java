package com.hbjg.system.dao;

import com.hbjg.system.mapper.SlrMapper;
import com.hbjg.system.pojo.Slr;
import com.hbjg.system.pojo.SlrListDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SlrMapperTest {

    @Autowired
    private SlrMapper slrMapper;

    @Test
    public void test01(){
        List<SlrListDto> slrListDtos = slrMapper.selectAll();
        System.out.println(slrListDtos);
    }

    @Test
    public void test02(){
        Slr slr = slrMapper.selectByUidAndPid(1, 2);
        System.out.println(slr);
    }

    @Test
    public void test03(){
        Boolean aBoolean = slrMapper.AddNumByUidAndPid(11, 2, 10);
        System.out.println(aBoolean);
    }

    @Test
    public void test04(){
        Boolean aBoolean = slrMapper.SubNumByUidAndPid(11, 2, 3);
        System.out.println(aBoolean);
    }
}
