package com.hbjg.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbjg.system.mapper.DeliverylogMapper;
import com.hbjg.system.pojo.Deliverylog;
import com.hbjg.system.pojo.DeliverylogListDto;
import com.hbjg.system.service.IDeliverylogService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DeliverylogServiceImpl extends ServiceImpl<DeliverylogMapper, Deliverylog> implements IDeliverylogService {

    @Autowired
    private DeliverylogMapper deliverylogMapper;

    @Override
    public IPage<DeliverylogListDto> selectDlogMyPage(Integer currentPage, Integer pageSize, DeliverylogListDto deliverylogListDto) {
        IPage<DeliverylogListDto> page = new Page<>(currentPage,pageSize);
        QueryWrapper<DeliverylogListDto> queryWrapper = new QueryWrapper<>();
        if(Strings.isNotEmpty(deliverylogListDto.getName())) {
            queryWrapper.like("tb_user.name", deliverylogListDto.getName());
        }
        return deliverylogMapper.selectDlogMyPage(page,queryWrapper);
    }
}
