package com.hbjg.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbjg.system.mapper.RepairlogMapper;
import com.hbjg.system.pojo.Repairlog;
import com.hbjg.system.pojo.RepairlogListDto;
import com.hbjg.system.pojo.User;
import com.hbjg.system.pojo.UserListDto;
import com.hbjg.system.service.IRepairlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RepairlogServiceImpl extends ServiceImpl<RepairlogMapper, Repairlog> implements IRepairlogService {

    @Autowired
    private RepairlogMapper repairlogMapper;

    @Override
    public IPage<RepairlogListDto> getReplogMyPage(Integer currentPage, Integer pageSize){

        //将条件封装到QueryWrapper中
        QueryWrapper<Repairlog> queryWrapper = new QueryWrapper<Repairlog>();

        IPage<RepairlogListDto> page = new Page(currentPage,pageSize);
        page = repairlogMapper.selectReplogMyPage(page, queryWrapper);
        return page;
    }

}
