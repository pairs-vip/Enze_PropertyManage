package com.hbjg.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbjg.system.mapper.OfficalWebMapper;
import com.hbjg.system.pojo.OfficalWeb;
import com.hbjg.system.service.IOfficalWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficalWebServiceImpl extends ServiceImpl<OfficalWebMapper, OfficalWeb> implements IOfficalWebService {

    @Autowired
    private OfficalWebMapper officalWebMapper;

}
