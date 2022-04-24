package com.hbjg.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.hbjg.system.pojo.Scraplog;
import com.hbjg.system.pojo.ScraplogListDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ScraplogMapper extends MyBaseMapper<Scraplog> {


    IPage<ScraplogListDto> selectScrlogMyPage(IPage<ScraplogListDto> page, @Param(Constants.WRAPPER) QueryWrapper<Scraplog> queryWrapper);

}
