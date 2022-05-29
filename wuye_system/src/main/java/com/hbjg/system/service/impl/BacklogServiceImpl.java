package com.hbjg.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbjg.system.mapper.BacklogMapper;
import com.hbjg.system.pojo.Backlog;
import com.hbjg.system.pojo.Condition;
import com.hbjg.system.service.IBacklogService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BacklogServiceImpl extends ServiceImpl<BacklogMapper, Backlog> implements IBacklogService {

    @Autowired
    private BacklogMapper backlogMapper;

    @Override
    public IPage<Backlog> selectBacklogMyPage(Integer currentPage, Integer pageSize, Condition condition) {
        IPage<Backlog> page = new Page<>(currentPage,pageSize);
        QueryWrapper<Backlog> queryWrapper = new QueryWrapper<>();
        if(Strings.isNotEmpty(condition.getPropertyName())){
            queryWrapper.like("tb_backlog.property_name",condition.getPropertyName());
        }
        if(Strings.isNotEmpty(condition.getBegin())){
            queryWrapper.ge("tb_backlog.time",condition.getBegin());
        }
        if(Strings.isNotEmpty(condition.getEnd())){
            queryWrapper.le("tb_backlog.time",condition.getEnd());
        }
         page = backlogMapper.selectPage(page, queryWrapper);
        return page;
    }
}
