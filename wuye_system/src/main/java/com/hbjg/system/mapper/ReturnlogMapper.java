package com.hbjg.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.hbjg.system.pojo.Returnlog;
import com.hbjg.system.pojo.ReturnlogListDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReturnlogMapper extends MyBaseMapper<Returnlog> {

        //分页查询所有借出归还纪录
        IPage<ReturnlogListDto> selectReturnlogMyPage(IPage<ReturnlogListDto> page, @Param(Constants.WRAPPER) QueryWrapper<Returnlog> queryWrapper);

}
