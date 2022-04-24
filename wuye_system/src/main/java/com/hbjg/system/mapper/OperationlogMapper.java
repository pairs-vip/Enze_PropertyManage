package com.hbjg.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.hbjg.system.pojo.Operationlog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OperationlogMapper extends MyBaseMapper<Operationlog> {

    IPage<Operationlog> selectOlogMyPage(IPage<Operationlog> page, @Param(Constants.WRAPPER) QueryWrapper<Operationlog> queryWrapper);
}
