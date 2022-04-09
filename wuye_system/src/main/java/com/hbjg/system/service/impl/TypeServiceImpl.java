package com.hbjg.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbjg.system.mapper.TypeMapper;
import com.hbjg.system.pojo.Type;
import com.hbjg.system.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper,Type> implements ITypeService {

    @Autowired
    private TypeMapper typeMapper;
}
