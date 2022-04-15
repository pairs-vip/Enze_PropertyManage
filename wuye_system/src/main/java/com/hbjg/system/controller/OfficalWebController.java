package com.hbjg.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hbjg.system.controller.utils.R;
import com.hbjg.system.pojo.OfficalWeb;
import com.hbjg.system.service.IOfficalWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/officalWebsite")
public class OfficalWebController {

    @Autowired
    private IOfficalWebService iOfficalWebService;

    @GetMapping("/search")
    public R getwebsitmsg(@RequestBody Map searchMap){
        QueryWrapper<OfficalWeb> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("tb_officalwebsite.title",searchMap.get("title"));
//        iOfficalWebService.list(queryWrapper);
        return new R(true,20000,iOfficalWebService.list(queryWrapper));
    }

    @GetMapping("/getofficalwebsite")
    public R getwebsitelist(){
        return new R(true,20000,iOfficalWebService.list());
    }
}
