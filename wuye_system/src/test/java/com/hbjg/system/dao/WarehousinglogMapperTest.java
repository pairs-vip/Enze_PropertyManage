package com.hbjg.system.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbjg.system.mapper.WarehousinglogMapper;
import com.hbjg.system.pojo.WarehousinglogListDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class WarehousinglogMapperTest {

    @Autowired
    private WarehousinglogMapper warehousinglogMapper;

    @Test
    public void test01(){

        IPage<WarehousinglogListDto> page = new Page<>(1,10);
        QueryWrapper<WarehousinglogListDto> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("tb_user.name","张");
        warehousinglogMapper.selectWlogMyPage(page,queryWrapper);
    }
    @Test
    public void test02() throws ParseException {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = formatter.format(new Date());
        Date date = formatter.parse(s);
        System.out.println(date);
    }
}
