package com.hbjg.system.dao;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbjg.system.mapper.ReturnlogMapper;
import com.hbjg.system.pojo.Returnlog;
import com.hbjg.system.pojo.ReturnlogListDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReturnlogMapperTest {

    @Autowired
    private ReturnlogMapper returnlogMapper;


    @Test
    public void test01(){
        IPage<ReturnlogListDto> page = new Page<>(1,10);
        QueryWrapper<Returnlog> queryWrapper = new QueryWrapper<>();
        returnlogMapper.selectReturnlogMyPage(page,queryWrapper);

    }
}
