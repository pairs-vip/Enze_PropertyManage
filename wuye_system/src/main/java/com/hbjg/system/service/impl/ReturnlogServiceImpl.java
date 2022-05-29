package com.hbjg.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbjg.system.mapper.LendlogMapper;
import com.hbjg.system.mapper.ReturnlogMapper;
import com.hbjg.system.pojo.*;
import com.hbjg.system.service.IReturnlogService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


@Service
public class ReturnlogServiceImpl extends ServiceImpl<ReturnlogMapper, Returnlog> implements IReturnlogService {

    @Autowired
    private ReturnlogMapper returnlogMapper;


    //分页查看所有
    @Override
    public IPage<ReturnlogListDto> getReturnlogMyPage(Integer currentPage, Integer pageSize,Condition condition) {

        IPage<ReturnlogListDto> page = new Page<>(currentPage,pageSize);

        QueryWrapper<Returnlog> queryWrapper = new QueryWrapper<>();

        String propertyName = condition.getPropertyName();
        Integer status = condition.getStatus();
        String begin = condition.getBegin();
        String end = condition.getEnd();

        if(Strings.isNotEmpty(propertyName)) {
            queryWrapper.like("tb_property.pname", propertyName);
        }
        if(status!=null) {
            queryWrapper.like("tb_returnlog.status", status);
        }
        if(Strings.isNotEmpty(begin)) {
            queryWrapper.ge("tb_returnlog.time",begin);
        }
        if(Strings.isNotEmpty(end)) {
            queryWrapper.le("tb_returnlog.time",end);
        }


        page = returnlogMapper.selectReturnlogMyPage(page,queryWrapper);
        return page;
    }

    //查看当前登录用户得纪录，并且条件有已同意和未同意两种
    @Override
    public IPage<ReturnlogListDto> getReturnlogForUser1(Integer currentPage, Integer pageSize, Returnlog returnlog, HttpSession session) {

        IPage<ReturnlogListDto> page = new Page<>(currentPage,pageSize);
        User user = (User)session.getAttribute("user");
        QueryWrapper<Returnlog> queryWrapper = new QueryWrapper<>();
        if(user!=null){
            Integer uid = user.getId();
            queryWrapper.eq("tb_returnlog.user_id1",uid);
        }
        Integer status = returnlog.getStatus();
        if(status!=null){
            queryWrapper.eq("tb_returnlog.status",status);
        }
        page = returnlogMapper.selectReturnlogMyPage(page,queryWrapper);
        return page;
    }

    @Override
    public IPage<ReturnlogListDto> getReturnlogForUser2(Integer currentPage, Integer pageSize, Returnlog returnlog, HttpSession session) {

        IPage<ReturnlogListDto> page = new Page<>(currentPage,pageSize);
        User user = (User)session.getAttribute("user");
        QueryWrapper<Returnlog> queryWrapper = new QueryWrapper<>();
        if(user!=null){
            Integer uid = user.getId();
            queryWrapper.eq("tb_returnlog.user_id2",uid);
        }
        Integer status = returnlog.getStatus();
        if(status!=null){
            queryWrapper.eq("tb_returnlog.status",status);
        }
        page = returnlogMapper.selectReturnlogMyPage(page,queryWrapper);
        return page;
    }

}

