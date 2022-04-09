package com.hbjg.system.dao;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbjg.system.mapper.LendlogMapper;
import com.hbjg.system.pojo.Lendlog;
import com.hbjg.system.pojo.LendlogListDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LendlogMapperTest {

    @Autowired
    private LendlogMapper lendlogMapper;


    @Test
    public void test01(){
        IPage<LendlogListDto> page = new Page<>(1,1);
        QueryWrapper<Lendlog> queryWrapper = new QueryWrapper<>();
        page = lendlogMapper.selectLendlogMyPage(page, queryWrapper);
        System.out.println(page);
    }

    @Test
    public void test02(){
        IPage<LendlogListDto> page = new Page<>(1,10);
        QueryWrapper<Lendlog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("tb_lendlog.uid2",12);
        page = lendlogMapper.selectLendlogMyPage(page,queryWrapper);
        System.out.println(page);
    }
}
