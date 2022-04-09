package com.hbjg.system.mapper;

import com.hbjg.system.pojo.Type2;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface Type2Mapper extends MyBaseMapper<Type2> {

    public List<Type2> getT2ByT(Integer tid);

}
