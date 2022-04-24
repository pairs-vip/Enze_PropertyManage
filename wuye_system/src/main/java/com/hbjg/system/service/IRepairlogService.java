package com.hbjg.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hbjg.system.pojo.Repairlog;
import com.hbjg.system.pojo.RepairlogListDto;

public interface IRepairlogService extends IService<Repairlog> {


    IPage<RepairlogListDto> getReplogMyPage(Integer currentPage,Integer pageSize);
}
