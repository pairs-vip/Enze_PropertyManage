package com.hbjg.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbjg.system.mapper.LendlogMapper;
import com.hbjg.system.pojo.*;
import com.hbjg.system.service.ILendlogService;
import org.apache.logging.log4j.util.Constants;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class LendlogServiceImpl extends ServiceImpl<LendlogMapper, Lendlog> implements ILendlogService {

    @Autowired
    private LendlogMapper lendlogMapper;


    //分页查看所有
    @Override
    public IPage<LendlogListDto> getLendlogMyPage(Integer currentPage, Integer pageSize, Condition condition) {

        IPage<LendlogListDto> page = new Page<>(currentPage,pageSize);

        QueryWrapper<Lendlog> queryWrapper = new QueryWrapper<>();
        String propertyName = condition.getPropertyName();
        String status = condition.getStatus();
        String begin = condition.getBegin();
        String end = condition.getEnd();

        if(Strings.isNotEmpty(propertyName)) {
            queryWrapper.like("tb_property.pname", propertyName);
        }
        if(Strings.isNotEmpty(status)) {
            queryWrapper.like("tb_lendlog.status", status);
        }
        if(Strings.isNotEmpty(begin)) {
            queryWrapper.ge("tb_lendlog.time",begin);
        }
        if(Strings.isNotEmpty(end)) {
            queryWrapper.le("tb_lendlog.time",end);
        }

        page = lendlogMapper.selectLendlogMyPage(page,queryWrapper);
        return page;
    }

    //查看当前登录用户得纪录，并且条件有已同意和未同意两种
    @Override
    public IPage<LendlogListDto> getLendForUser1(Integer currentPage,Integer pageSize,Lendlog lendlog,HttpSession session) {

        IPage<LendlogListDto> page = new Page<>(currentPage,pageSize);
        User user = (User)session.getAttribute("user");
        QueryWrapper<Lendlog> queryWrapper = new QueryWrapper<Lendlog>();

        if(user!=null){
            Integer uid = user.getUid();
            queryWrapper.eq("tb_lendlog.uid1",uid);
        }
        String status = lendlog.getStatus();
        if(Strings.isNotEmpty(status)){
            queryWrapper.eq("tb_lendlog.status",status);
        }
        page = lendlogMapper.selectLendlogMyPage(page,queryWrapper);
        return page;
    }

    @Override
    public IPage<LendlogListDto> getLendForUser2(Integer currentPage,Integer pageSize,Lendlog lendlog,HttpSession session) {

        IPage<LendlogListDto> page = new Page<>(currentPage,pageSize);
        User user = (User)session.getAttribute("user");
        QueryWrapper<Lendlog> queryWrapper = new QueryWrapper<Lendlog>();
        if(user!=null){
            Integer uid = user.getUid();
            queryWrapper.eq("tb_lendlog.uid2",uid);
        }
        String status = lendlog.getStatus();
        if(Strings.isNotEmpty(status)){
            queryWrapper.eq("tb_lendlog.status",status);
        }
        page = lendlogMapper.selectLendlogMyPage(page,queryWrapper);
        return page;
    }
}
