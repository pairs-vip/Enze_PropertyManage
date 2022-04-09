package com.hbjg.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.hbjg.system.pojo.Deliverylog;
import com.hbjg.system.pojo.DeliverylogListDto;
import com.hbjg.system.pojo.Property;
import com.hbjg.system.pojo.PropertyListDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DeliverylogMapper extends MyBaseMapper<Deliverylog> {

    IPage<DeliverylogListDto> selectDlogMyPage(IPage<DeliverylogListDto> page, @Param(Constants.WRAPPER) QueryWrapper<DeliverylogListDto> queryWrapper);

}
