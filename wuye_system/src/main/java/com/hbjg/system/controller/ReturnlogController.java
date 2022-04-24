package com.hbjg.system.controller;


import com.hbjg.system.pojo.Returnlog;
import com.hbjg.system.utils.R;
import com.hbjg.system.pojo.Condition;
import com.hbjg.system.service.IReturnlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@CrossOrigin
@RestController
@RequestMapping("/returnlogs")
public class ReturnlogController {

    @Autowired
    private IReturnlogService iReturnlogService;

    //查看所有归还纪录分页
    @PostMapping("/{currentPage}/{pageSize}")
    public R getReturnlogMyPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize, @RequestBody Condition condition){
        return new R(true,20000,iReturnlogService.getReturnlogMyPage(currentPage,pageSize,condition));
    }

    //修改审核状态进行审核
    @PutMapping
    public R updateStatusByLlid(@RequestBody Returnlog returnlog){
        return new R(true,20000,iReturnlogService.updateById(returnlog));
    }


    //通过当前用户查看，可以查看已审核或者未审核
    @PostMapping("/getforuser/{currentPage}/{pageSize}")
    public R getLendForUser(@PathVariable Integer currentPage, @PathVariable Integer pageSize, HttpSession session, @RequestBody Returnlog returnlog){
        return new R(true,20000,iReturnlogService.getReturnlogForUser2(currentPage,pageSize,returnlog,session));
    }

    //通过id查询一条纪录
    @GetMapping("/{rlid}")
    public R getOneReturnlog(@PathVariable Integer rlid){
        return new R(true,20000,iReturnlogService.getById(rlid));
    }
}
