package com.hbjg.system.controller;


import com.hbjg.system.controller.utils.R;
import com.hbjg.system.pojo.Lendlog;
import com.hbjg.system.service.ILendlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/lendlogs")
public class LendlogController {

    @Autowired
    private ILendlogService iLendlogService;

    //查看所有借出纪录分页
    @GetMapping
    public R getLendlogMyPage(){
        return new R(true,iLendlogService.getLendlogMyPage(1,10,null));
    }

    //将未同意改为已同意
    @PutMapping
    public R updateStatusByLlid(@RequestBody Lendlog lendlog){
        return new R(true,iLendlogService.updateById(lendlog));
    }
    //通过当前用户查看，将已同意或未同意用作参数传递过来
    @GetMapping("/getforuser/{currentPage}/{pageSize}")
    public R getLendForUser(@PathVariable Integer currentPage,@PathVariable Integer pageSize, HttpSession session, @RequestBody Lendlog lendlog){
        return new R(true,iLendlogService.getLendForUser(currentPage,pageSize,lendlog,session));
    }
}
