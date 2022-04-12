package com.hbjg.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbjg.system.mapper.PurchaselogMapper;
import com.hbjg.system.pojo.Condition;
import com.hbjg.system.pojo.Purchaselog;
import com.hbjg.system.service.IPurchaselogService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PurhcaselogServiceImpl extends ServiceImpl<PurchaselogMapper, Purchaselog> implements IPurchaselogService {

    @Autowired
    private PurchaselogMapper purchaselogMapper;

    @Override
    public IPage<Purchaselog> selectPurlogMyPage(Integer currentPage,Integer pageSize,Condition condition) {
        IPage<Purchaselog> page = new Page<>(currentPage,pageSize);
        QueryWrapper<Purchaselog> queryWrapper = new QueryWrapper<>();
        if(Strings.isNotEmpty(condition.getPropertyName())){
            queryWrapper.like("tb_purchaselog.property_name",condition.getPropertyName());
        }
        if(Strings.isNotEmpty(condition.getBegin())){
            queryWrapper.ge("tb_purchaselog.purchaselog_time",condition.getBegin());
        }
        if(Strings.isNotEmpty(condition.getEnd())){
            queryWrapper.le("tb_purchaselog.purchaselog_time",condition.getEnd());
        }
        page = purchaselogMapper.selectPage(page, queryWrapper);
        return page;
    }
}
