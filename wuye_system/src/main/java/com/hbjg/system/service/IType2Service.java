package com.hbjg.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hbjg.system.pojo.Type2;

import java.util.List;

public interface IType2Service extends IService<Type2> {

    public List<Type2> getType2ByType(Integer tid);
}
