package com.hbjg.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbjg.system.mapper.Type2Mapper;
import com.hbjg.system.pojo.Type2;
import com.hbjg.system.service.IType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Type2ServiceImpl extends ServiceImpl<Type2Mapper, Type2> implements IType2Service {

    @Autowired
    private Type2Mapper type2Mapper;

    @Override
    public List<Type2> getType2ByType(Integer tid) {
        return type2Mapper.getT2ByT(tid);
    }
}
