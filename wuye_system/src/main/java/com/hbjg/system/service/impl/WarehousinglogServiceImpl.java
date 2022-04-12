package com.hbjg.system.service.impl;

import com.alibaba.druid.sql.dialect.postgresql.ast.expr.PGMacAddrExpr;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbjg.system.mapper.WarehousinglogMapper;
import com.hbjg.system.pojo.Condition;
import com.hbjg.system.pojo.Warehousinglog;
import com.hbjg.system.pojo.WarehousinglogListDto;
import com.hbjg.system.service.IWarehousinglogService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class WarehousinglogServiceImpl extends ServiceImpl<WarehousinglogMapper, Warehousinglog> implements IWarehousinglogService {


    @Autowired
    private WarehousinglogMapper warehousinglogMapper;
    @Override
    public IPage<WarehousinglogListDto> selectWlogMyPage(Integer currentPage, Integer pageSize, Condition condition) {
        IPage<WarehousinglogListDto> page = new Page<>(currentPage,pageSize);
        QueryWrapper<WarehousinglogListDto> queryWrapper = new QueryWrapper<>();
        if(Strings.isNotEmpty(condition.getPropertyName())){
            queryWrapper.like("tb_property.pname",condition.getPropertyName());
        }
        if(Strings.isNotEmpty(condition.getBegin())){
            queryWrapper.ge("tb_warehousinglog.warehousingDate",condition.getBegin());
        }
        if(Strings.isNotEmpty(condition.getEnd())){
            queryWrapper.le("tb_warehousinglog.warehousingDate",condition.getEnd());
        }
        page = warehousinglogMapper.selectWlogMyPage(page,queryWrapper);
        return page;
    }
}
