package com.hbjg.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.hbjg.system.pojo.Slr;
import com.hbjg.system.pojo.SlrListDto;
import com.hbjg.system.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SlrMapper extends MyBaseMapper<Slr> {

    //根据用户id和物品id找纪录
    Slr selectByUidAndPid(Integer uid,Integer pid);

    List<SlrListDto> selectAll();

    Boolean AddNumByUidAndPid(Integer uid,Integer pid,Integer number);

    Boolean SubNumByUidAndPid(Integer uid,Integer pid,Integer number);


}
