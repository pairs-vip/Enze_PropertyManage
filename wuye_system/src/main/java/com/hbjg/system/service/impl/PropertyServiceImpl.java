package com.hbjg.system.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbjg.system.mapper.PropertyMapper;
import com.hbjg.system.pojo.Property;
import com.hbjg.system.pojo.PropertyListDto;
import com.hbjg.system.pojo.User;
import com.hbjg.system.pojo.UserListDto;
import com.hbjg.system.service.IPropertyService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceImpl extends ServiceImpl<PropertyMapper, Property> implements IPropertyService {


    @Autowired
    private PropertyMapper propertyMapper;

    //分页查询，封装条件
    @Override
    public IPage<PropertyListDto> getProMyPage(Integer currentPage, Integer pageSize, Property property) {

        IPage<PropertyListDto> page = new Page(currentPage,pageSize);
        QueryWrapper<Property> queryWrapper = new QueryWrapper<Property>();
        if(Strings.isNotEmpty(property.getPname())){
            queryWrapper.like("tb_property.pname",property.getPname());
        }

        if(property.getType() != null) {
            queryWrapper.eq("tb_property.type", property.getType());
        }
        if(property.getType2() != null){
            queryWrapper.eq("tb_property.type2",property.getType2());
        }


        page = propertyMapper.selectProMyPage(page, queryWrapper);
        return page;
    }

    //根据id修改物品数量
    @Override
    public Integer addNum(Integer pid, Integer number) {
        return propertyMapper.addNum(pid,number);
    }

    //根据id修改物品数量
    @Override
    public Integer subNum(Integer pid, Integer number) {
        return propertyMapper.subNum(pid,number);
    }

    //根据名称获取物品
    @Override
    public Property getProByName(String pname) {
        return propertyMapper.selectProByName(pname);
    }

    @Override
    public Property getProByNameAndSpec(String pname, String spec) {
        return propertyMapper.selectProByNameAndSpec(pname,spec);
    }

    @Override
    public Property getProByNameAndSpecAndType(String panme, String spec, Integer type, Integer type2) {
        return propertyMapper.selectProByNameAndSpecAndType(panme,spec,type,type2);
    }


}
