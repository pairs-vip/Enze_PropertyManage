package com.hbjg.system.controller;


import com.hbjg.system.controller.utils.R;
import com.hbjg.system.pojo.Returnlog;
import com.hbjg.system.service.IReturnlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/returnlogs")
public class ReturnlogController {

    @Autowired
    private IReturnlogService iReturnlogService;

    //查看所有归还纪录分页
    @GetMapping
    public R getReturnlogMyPage(){
        return new R(true,iReturnlogService.getReturnlogMyPage(1,10,null));
    }

    //修改未同意为已同意
    @PutMapping
    public R updateStatusByLlid(@RequestBody Returnlog returnlog){
        return new R(true,iReturnlogService.updateById(returnlog));
    }


    //通过当前用户查看，将已同意或未同意用作参数传递过来
    @GetMapping("/getforuser/{currentPage}/{pageSize}")
    public R getLendForUser(@PathVariable Integer currentPage, @PathVariable Integer pageSize, HttpSession session, @RequestBody Returnlog returnlog){
        return new R(true,iReturnlogService.getReturnlogForUser(currentPage,pageSize,returnlog,session));
    }
}
