package com.hbjg.system.controller;


import com.hbjg.system.pojo.Lendlog;
import com.hbjg.system.utils.R;
import com.hbjg.system.pojo.Condition;
import com.hbjg.system.service.ILendlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@CrossOrigin
@RestController
@RequestMapping("/lendlogs")
public class LendlogController {

    @Autowired
    private ILendlogService iLendlogService;

    //查看所有借出纪录分页
    @PostMapping("/{currentPage}/{pageSize}")
    public R getLendlogMyPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize,@RequestBody  Condition condition){
        return new R(true,20000,iLendlogService.getLendlogMyPage(currentPage,pageSize,condition));
    }

    //将未审核改为已审核
    @PutMapping
    public R updateStatusByLlid(@RequestBody Lendlog lendlog){
        return new R(true,20000,iLendlogService.updateById(lendlog));
    }
    //通过当前用户查看，将已同意或未同意用作参数传递过来
    //用来审核
    @PostMapping("/getforuser/{currentPage}/{pageSize}")
    public R getLendForUser(@PathVariable Integer currentPage, @PathVariable Integer pageSize, HttpSession session, @RequestBody Lendlog lendlog){
        return new R(true,20000,iLendlogService.getLendForUser2(currentPage,pageSize,lendlog,session));
    }
    //通过id来查询一条纪录
    @GetMapping("/{id}")
    public  R getOneLendlog(@PathVariable Integer id){
        return new R(true,20000,iLendlogService.getById(id));
    }

}
