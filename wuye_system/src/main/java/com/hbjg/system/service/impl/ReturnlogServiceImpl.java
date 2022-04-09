package com.hbjg.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbjg.system.mapper.LendlogMapper;
import com.hbjg.system.mapper.ReturnlogMapper;
import com.hbjg.system.pojo.*;
import com.hbjg.system.service.IReturnlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


@Service
public class ReturnlogServiceImpl extends ServiceImpl<ReturnlogMapper, Returnlog> implements IReturnlogService {

    @Autowired
    private ReturnlogMapper returnlogMapper;


    //分页查看所有
    @Override
    public IPage<ReturnlogListDto> getReturnlogMyPage(Integer currentPage, Integer pageSize, Returnlog returnlog) {

        IPage<ReturnlogListDto> page = new Page<>(currentPage,pageSize);

        QueryWrapper<Returnlog> queryWrapper = new QueryWrapper<>();

        page = returnlogMapper.selectReturnlogMyPage(page,queryWrapper);
        return page;
    }

    //查看当前登录用户得纪录，并且条件有已同意和未同意两种
    @Override
    public IPage<ReturnlogListDto> getReturnlogForUser(Integer currentPage, Integer pageSize, Returnlog returnlog, HttpSession session) {

        IPage<ReturnlogListDto> page = new Page<>(currentPage,pageSize);
        User user = (User)session.getAttribute("user");
        Integer uid = user.getUid();
        QueryWrapper<Returnlog> queryWrapper = new QueryWrapper<>();
        String status = returnlog.getStatus();
        queryWrapper.eq("tb_returnlog.uid2",uid);
        queryWrapper.eq("tb_returnlog.status",status);
        page = returnlogMapper.selectReturnlogMyPage(page,queryWrapper);
        return page;
    }

}

