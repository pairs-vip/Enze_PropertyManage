package com.hbjg.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbjg.system.mapper.OperationlogMapper;
import com.hbjg.system.pojo.DeliverylogListDto;
import com.hbjg.system.pojo.Operationlog;
import com.hbjg.system.service.IOperationlogService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class OperationlogServiceImpl extends ServiceImpl<OperationlogMapper, Operationlog> implements IOperationlogService {


    @Autowired
    private OperationlogMapper operationlogMapper;

    @Override
    public IPage<Operationlog> getOperationlogMyPage(Integer currentPage, Integer pageSize, Operationlog operationlog) {
        IPage<Operationlog> page = new Page<>(currentPage,pageSize);
        QueryWrapper<Operationlog> queryWrapper = new QueryWrapper<>();
        if(Strings.isNotEmpty(operationlog.getOperationObj())) {
            queryWrapper.like("tb_operationlog.operation_obj", operationlog.getOperationObj());
        }
        if(Strings.isNotEmpty(operationlog.getOperationType())){
            queryWrapper.like("tb_operationlog.operation_type",operationlog.getOperationType());
        }
        if(Strings.isNotEmpty(operationlog.getOperationTime1())){
            queryWrapper.ge("tb_operationlog.operation_time",operationlog.getOperationTime1());
        }
        if(Strings.isNotEmpty(operationlog.getOperationTime2())){
            queryWrapper.le("tb_operationlog.operation_time",operationlog.getOperationTime2());
        }
        page = operationlogMapper.selectOlogMyPage(page, queryWrapper);
        return page;
    }
}
