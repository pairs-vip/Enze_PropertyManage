package com.hbjg.system.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.hbjg.system.pojo.Repairlog;
import com.hbjg.system.pojo.RepairlogListDto;
import com.hbjg.system.pojo.User;
import com.hbjg.system.pojo.UserListDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface RepairlogMapper extends MyBaseMapper<Repairlog>{

    IPage<RepairlogListDto> selectReplogMyPage(IPage<RepairlogListDto> page, @Param(Constants.WRAPPER) QueryWrapper<Repairlog> queryWrapper);
}
