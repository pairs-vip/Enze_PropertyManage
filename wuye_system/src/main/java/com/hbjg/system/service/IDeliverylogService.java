package com.hbjg.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hbjg.system.pojo.Deliverylog;
import com.hbjg.system.pojo.DeliverylogListDto;

public interface IDeliverylogService extends IService<Deliverylog> {

    IPage<DeliverylogListDto> selectDlogMyPage(Integer currentPage,Integer pageSize,DeliverylogListDto deliverylogListDto);
}
