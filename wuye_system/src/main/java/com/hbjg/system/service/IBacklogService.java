package com.hbjg.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hbjg.system.pojo.Backlog;
import com.hbjg.system.pojo.Condition;
import org.springframework.beans.factory.annotation.Autowired;

public interface IBacklogService extends IService<Backlog> {


    IPage<Backlog> selectBacklogMyPage(Integer currentPage, Integer pageSize, Condition condition);
}
