package com.hbjg.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hbjg.system.pojo.Condition;
import com.hbjg.system.pojo.Purchaselog;

public interface IPurchaselogService extends IService<Purchaselog> {

    //分页查询采购列表
    IPage<Purchaselog> selectPurlogMyPage(Integer currentPage,Integer pageSize,Condition condition);
}
