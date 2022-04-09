package com.hbjg.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbjg.system.mapper.StorageitemsMapper;
import com.hbjg.system.pojo.Storageitems;
import com.hbjg.system.service.IStorageitemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageitemsServiceImpl extends ServiceImpl<StorageitemsMapper,Storageitems> implements IStorageitemsService {

    @Autowired
    private StorageitemsMapper storageitemsMapper;
}
