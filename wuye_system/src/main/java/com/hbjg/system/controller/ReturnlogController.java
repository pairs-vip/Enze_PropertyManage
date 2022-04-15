package com.hbjg.system.controller;


import com.hbjg.system.controller.utils.R;
import com.hbjg.system.pojo.Condition;
import com.hbjg.system.pojo.Returnlog;
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
//    @PutMapping
//    public R updateStatusByLlid(@RequestBody Returnlog returnlog){
//        return new R(true,iReturnlogService.updateById(returnlog));
//    }


    //通过当前用户查看，将已同意或未同意用作参数传递过来
//    @GetMapping("/getforuser/{currentPage}/{pageSize}")
//    public R getLendForUser(@PathVariable Integer currentPage, @PathVariable Integer pageSize, HttpSession session, @RequestBody Returnlog returnlog){
//        return new R(true,iReturnlogService.getReturnlogForUser(currentPage,pageSize,returnlog,session));
//    }
}
