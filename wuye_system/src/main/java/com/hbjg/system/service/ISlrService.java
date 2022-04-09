package com.hbjg.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hbjg.system.pojo.Lendlog;
import com.hbjg.system.pojo.Slr;
import com.hbjg.system.pojo.SlrListDto;

import java.util.List;

public interface ISlrService extends IService<Slr> {

    List<SlrListDto> selectAll();

    Slr selectByUidAndPid(Integer uid,Integer pid);

    Boolean AddNumByUidAndPid(Lendlog lendlog);

    Boolean SubNumByUidAndPid(Lendlog lendlog);
}
