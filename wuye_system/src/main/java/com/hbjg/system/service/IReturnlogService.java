package com.hbjg.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hbjg.system.pojo.*;

import javax.servlet.http.HttpSession;

public interface IReturnlogService extends IService<Returnlog> {

    IPage<ReturnlogListDto> getReturnlogMyPage(Integer currentPage, Integer pageSize, Condition condition);

    IPage<ReturnlogListDto> getReturnlogForUser1(Integer currentPage, Integer pageSize, Returnlog returnlog, HttpSession session);

    IPage<ReturnlogListDto> getReturnlogForUser2(Integer currentPage, Integer pageSize, Returnlog returnlog, HttpSession session);
}
