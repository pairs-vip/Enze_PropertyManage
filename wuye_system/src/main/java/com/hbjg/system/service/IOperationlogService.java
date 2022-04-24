package com.hbjg.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hbjg.system.pojo.Operationlog;

public interface IOperationlogService extends IService<Operationlog> {


    IPage<Operationlog> getOperationlogMyPage(Integer currentPage, Integer pageSize, Operationlog operationlog);
}
