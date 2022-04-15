package com.hbjg.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbjg.system.mapper.SlrMapper;
import com.hbjg.system.pojo.*;
import com.hbjg.system.service.ISlrService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class SlrServiceImpl extends ServiceImpl<SlrMapper, Slr> implements ISlrService {

    @Autowired
    private SlrMapper slrMapper;


    //查看当前所有纪录。
    @Override
    public IPage<SlrListDto> selectSlrMyPageForUser(Integer currentPage, Integer pageSize, Condition condition, HttpSession session) {
       IPage<SlrListDto> page = new Page<>(currentPage,pageSize);

        QueryWrapper<Condition> queryWrapper = new QueryWrapper<>();
        if(Strings.isNotEmpty(condition.getPropertyName())){
            queryWrapper.like("tb_property.pname",condition.getPropertyName());
        }
        User user = (User) session.getAttribute("user");
        if(user!=null){
            queryWrapper.eq("s.uid",user.getUid());
        }

        page = slrMapper.selectSlrMyPage(page,queryWrapper);

        return page;
    }

    @Override
    public IPage<SlrListDto> selectSlrMyPage(Integer currentPage, Integer pageSize, Condition condition) {

        IPage<SlrListDto> page = new Page<>(currentPage,pageSize);

        QueryWrapper<Condition> queryWrapper = new QueryWrapper<>();
        if(Strings.isNotEmpty(condition.getPropertyName())){
            queryWrapper.like("tb_property.pname",condition.getPropertyName());
        }

        page = slrMapper.selectSlrMyPage(page,queryWrapper);

        return page;
    }

    //通过用户id和物品id查找汇总表中得纪录。
    @Override
    public Slr selectByUidAndPid(Integer uid, Integer pid) {
        return slrMapper.selectByUidAndPid(uid,pid);
    }

    //进行汇总表得借出修改操作，如果已经存在同一个人借出同一物品，则直接进行数量增加，如果不是这样则新生成一条。
    @Override
    public Boolean AddNumByUidAndPid(Lendlog lendlog) {
        Integer uid = lendlog.getUid1();
        Integer pid = lendlog.getPid();
        Integer number = lendlog.getNumber();
        System.out.println("service"+lendlog);
        Slr slr = slrMapper.selectByUidAndPid(uid, pid);
        if(slr!=null){
            return slrMapper.AddNumByUidAndPid(uid, pid, number);
        }else{
            Slr slr1 = new Slr();
            slr1.setUid(uid);
            slr1.setPid(pid);
            slr1.setNumber(number);
            int insert = slrMapper.insert(slr1);
            if(insert!=0){
                return true;
            }else{
                return false;
            }
        }

    }

    //进行汇总表得归还修改，如果归还之后这条纪录为0，则删除。
    @Override
    public Boolean SubNumByUidAndPid(Returnlog returnlog) {
        Integer uid = returnlog.getUid1();
        Integer pid = returnlog.getPid();
        Integer number = returnlog.getNumber();
        Boolean aBoolean = slrMapper.SubNumByUidAndPid(uid, pid, number);
        Slr slr = slrMapper.selectByUidAndPid(uid, pid);
        slrMapper.deleteById(slr.getSlrid());
        return aBoolean;
    }
}
