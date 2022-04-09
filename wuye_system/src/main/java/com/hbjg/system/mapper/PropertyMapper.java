package com.hbjg.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.hbjg.system.pojo.Property;
import com.hbjg.system.pojo.PropertyListDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PropertyMapper extends MyBaseMapper<Property> {


    IPage<PropertyListDto> selectProMyPage(IPage<PropertyListDto> page, @Param(Constants.WRAPPER) QueryWrapper<Property> queryWrapper);

    Integer addNum(Integer pid,Integer number);

    Integer subNum(Integer pid,Integer number);

    Property selectProByName(String pname);

    Property selectProByNameAndSpec(String pname, String spec);

    Property selectProByNameAndSpecAndType(String pname, String spec, Integer type, Integer type2);
}
