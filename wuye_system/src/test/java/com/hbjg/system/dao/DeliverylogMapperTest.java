package com.hbjg.system.dao;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbjg.system.mapper.DeliverylogMapper;
import com.hbjg.system.pojo.DeliverylogListDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DeliverylogMapperTest {

    @Autowired
    private DeliverylogMapper deliverylogMapper;

    @Test
    public void getalltest(){

        IPage<DeliverylogListDto> page = new Page<>(2,1);
        QueryWrapper<DeliverylogListDto> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("tb_user.name","三");
        page = deliverylogMapper.selectDlogMyPage(page, queryWrapper);
        System.out.println(page);
    }
}
