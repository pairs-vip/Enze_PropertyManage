package com.hbjg.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hbjg.system.pojo.Condition;
import com.hbjg.system.pojo.Lendlog;
import com.hbjg.system.pojo.LendlogListDto;


import javax.servlet.http.HttpSession;


public interface ILendlogService extends IService<Lendlog> {

    IPage<LendlogListDto> getLendlogMyPage(Integer currentPage, Integer pageSize,Condition condition);

    //找到当前用户的借出纪录
    IPage<LendlogListDto> getLendForUser1(Integer currentPage,Integer pageSize,Lendlog lendlog,HttpSession session);

    //找到当前用户需要进行同意的借出纪录
    IPage<LendlogListDto> getLendForUser2(Integer currentPage,Integer pageSize,Lendlog lendlog,HttpSession session);
}
