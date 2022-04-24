package com.hbjg.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hbjg.system.pojo.*;
import org.omg.PortableInterceptor.INACTIVE;

public interface IPropertyService extends IService<Property> {

    IPage<PropertyListDto> getProMyPage(Integer currentPage, Integer pageSize, Property property);

    Integer addNum(Integer pid, Integer number);

    Integer subNum(Integer pid,Integer number);

    Property getProByName(String pname);

    Property getProByNameAndSpec(String pname, String spec);

    Property getProByNameAndSpecAndType(String panme,String spec,Integer type,Integer type2);

}
