package com.hbjg.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hbjg.system.pojo.RepairlogListDto;
import com.hbjg.system.pojo.Scraplog;
import com.hbjg.system.pojo.ScraplogListDto;

public interface IScraplogService extends IService<Scraplog> {

    IPage<ScraplogListDto> getScrlogMyPage(Integer currentPage, Integer pageSize);
}
