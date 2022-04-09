package com.hbjg.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hbjg.system.pojo.Lendlog;
import com.hbjg.system.pojo.LendlogListDto;
import com.hbjg.system.pojo.Returnlog;
import com.hbjg.system.pojo.ReturnlogListDto;

import javax.servlet.http.HttpSession;

public interface IReturnlogService extends IService<Returnlog> {

    IPage<ReturnlogListDto> getReturnlogMyPage(Integer currentPage, Integer pageSize, Returnlog returnlog);

    IPage<ReturnlogListDto> getReturnlogForUser(Integer currentPage, Integer pageSize, Returnlog returnlog, HttpSession session);
}
