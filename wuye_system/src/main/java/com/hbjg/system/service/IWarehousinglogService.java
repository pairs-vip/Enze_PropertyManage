package com.hbjg.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hbjg.system.pojo.Warehousinglog;
import com.hbjg.system.pojo.WarehousinglogListDto;

public interface IWarehousinglogService extends IService<Warehousinglog> {

    IPage<WarehousinglogListDto> selectWlogMyPage(Integer currentPage,Integer pageSize,WarehousinglogListDto warehousinglogListDto);
}
