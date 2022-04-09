package com.hbjg.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.hbjg.system.pojo.DeliverylogListDto;
import com.hbjg.system.pojo.Warehousinglog;
import com.hbjg.system.pojo.WarehousinglogListDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WarehousinglogMapper extends MyBaseMapper<Warehousinglog> {

    IPage<WarehousinglogListDto> selectWlogMyPage(IPage<WarehousinglogListDto> page, @Param(Constants.WRAPPER) QueryWrapper<WarehousinglogListDto> queryWrapper);
}
