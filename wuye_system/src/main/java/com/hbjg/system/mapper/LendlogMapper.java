package com.hbjg.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.hbjg.system.pojo.Condition;
import com.hbjg.system.pojo.Lendlog;
import com.hbjg.system.pojo.LendlogListDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface LendlogMapper extends MyBaseMapper<Lendlog> {

    //分页查询
    IPage<LendlogListDto> selectLendlogMyPage(IPage<LendlogListDto> page, @Param(Constants.WRAPPER) QueryWrapper<Lendlog> queryWrapper);

    //分页查询按condition条件(有日期区间)
    IPage<LendlogListDto> selectLendlogMyPageByCon(IPage<LendlogListDto> page,@Param(Constants.WRAPPER) QueryWrapper<Condition> queryWrapper);
}
