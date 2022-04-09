package com.hbjg.system.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hbjg.system.controller.utils.R;
import com.hbjg.system.pojo.Lendlog;
import com.hbjg.system.service.ISlrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/slrs")
public class SlrController {

    @Autowired
    private ISlrService iSlrService;

    @GetMapping
    public R getAll(){
       return new R(true,iSlrService.selectAll());
    }

    @PutMapping("/lend")
    public R AddNumber(@RequestBody Lendlog lendlog){
        System.out.println("controller"+lendlog);
        return new R(true,iSlrService.AddNumByUidAndPid(lendlog));
    }

    @PutMapping("/return")
    public R SubNumber(@RequestBody Lendlog lendlog){
        return new R(true,iSlrService.SubNumByUidAndPid(lendlog));
    }

}
