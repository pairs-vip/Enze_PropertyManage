package com.hbjg.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbjg.system.mapper.OfficalWebMapper;
import com.hbjg.system.pojo.OfficalWeb;
import com.hbjg.system.service.IOfficalWebService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficalWebServiceImpl extends ServiceImpl<OfficalWebMapper, OfficalWeb> implements IOfficalWebService {

    @Autowired
    private OfficalWebMapper officalWebMapper;

    @Override
    public List<OfficalWeb> selectByTitle(OfficalWeb officalWeb) {
        QueryWrapper<OfficalWeb> queryWrapper = new QueryWrapper<>();
        if(Strings.isNotEmpty(officalWeb.getTitle())){
            queryWrapper.like("tb_officalwebsite.title",officalWeb.getTitle());
        }
        return officalWebMapper.selectList(queryWrapper);
    }
}
