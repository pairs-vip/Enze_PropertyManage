package com.hbjg.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbjg.system.mapper.ScraplogMapper;
import com.hbjg.system.pojo.Repairlog;
import com.hbjg.system.pojo.RepairlogListDto;
import com.hbjg.system.pojo.Scraplog;
import com.hbjg.system.pojo.ScraplogListDto;
import com.hbjg.system.service.IScraplogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ScraplogServiceImpl extends ServiceImpl<ScraplogMapper, Scraplog> implements IScraplogService {

    @Autowired
    private ScraplogMapper scraplogMapper;

    @Override
    public IPage<ScraplogListDto> getScrlogMyPage(Integer currentPage, Integer pageSize){

        //将条件封装到QueryWrapper中
        QueryWrapper<Scraplog> queryWrapper = new QueryWrapper<Scraplog>();

        IPage<ScraplogListDto> page = new Page(currentPage,pageSize);
        page = scraplogMapper.selectScrlogMyPage(page, queryWrapper);
        return page;
    }
}
