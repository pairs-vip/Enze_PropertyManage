package com.hbjg.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hbjg.system.pojo.Lendlog;
import com.hbjg.system.pojo.LendlogListDto;


import javax.servlet.http.HttpSession;


public interface ILendlogService extends IService<Lendlog> {

    IPage<LendlogListDto> getLendlogMyPage(Integer currentPage, Integer pageSize, Lendlog lendlog);

    IPage<LendlogListDto> getLendForUser(Integer currentPage,Integer pageSize,Lendlog lendlog,HttpSession session);
}
