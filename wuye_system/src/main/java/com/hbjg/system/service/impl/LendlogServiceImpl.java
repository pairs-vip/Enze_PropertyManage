package com.hbjg.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbjg.system.mapper.LendlogMapper;
import com.hbjg.system.pojo.*;
import com.hbjg.system.service.ILendlogService;
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
    public IPage<LendlogListDto> getLendlogMyPage(Integer currentPage, Integer pageSize, Lendlog lendlog) {

        IPage<LendlogListDto> page = new Page<>(currentPage,pageSize);

        QueryWrapper<Lendlog> queryWrapper = new QueryWrapper<>();

        page = lendlogMapper.selectLendlogMyPage(page,queryWrapper);
        return page;
    }

    //查看当前登录用户得纪录，并且条件有已同意和未同意两种
    @Override
    public IPage<LendlogListDto> getLendForUser(Integer currentPage,Integer pageSize,Lendlog lendlog,HttpSession session) {

        IPage<LendlogListDto> page = new Page<>(currentPage,pageSize);
        User user = (User)session.getAttribute("user");
        Integer uid = user.getUid();
        QueryWrapper<Lendlog> queryWrapper = new QueryWrapper<Lendlog>();
        String status = lendlog.getStatus();
        queryWrapper.eq("tb_lendlog.uid2",uid);
        queryWrapper.eq("tb_lendlog.status",status);
        page = lendlogMapper.selectLendlogMyPage(page,queryWrapper);
        return page;
    }
}
