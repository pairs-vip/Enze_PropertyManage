package com.hbjg.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbjg.system.mapper.BacklogMapper;
import com.hbjg.system.pojo.Backlog;
import com.hbjg.system.service.IBacklogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BacklogServiceImpl extends ServiceImpl<BacklogMapper, Backlog> implements IBacklogService {

    @Autowired
    private BacklogMapper backlogMapper;
}
