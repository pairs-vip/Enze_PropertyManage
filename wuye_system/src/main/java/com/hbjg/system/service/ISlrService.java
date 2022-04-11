package com.hbjg.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hbjg.system.pojo.*;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface ISlrService extends IService<Slr> {

    //管理员查看当前未归还信息
    IPage<SlrListDto> selectSlrMyPage(Integer currentPage, Integer pageSize, Condition condition);
    //当前用户查看自己未归还信息
    IPage<SlrListDto> selectSlrMyPageForUser(Integer currentPage, Integer pageSize, Condition condition, HttpSession session);

    Slr selectByUidAndPid(Integer uid,Integer pid);

    Boolean AddNumByUidAndPid(Lendlog lendlog);

    Boolean SubNumByUidAndPid(Lendlog lendlog);
}
