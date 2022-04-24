package com.hbjg.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hbjg.system.utils.R;
import com.hbjg.system.pojo.OfficalWeb;
import com.hbjg.system.service.IOfficalWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/officalWebsite")
public class OfficalWebController {

    @Autowired
    private IOfficalWebService iOfficalWebService;

    @PostMapping("/search")
    public R getwebsitmsg(@RequestBody OfficalWeb officalWeb){
//        iOfficalWebService.list(queryWrapper);
        return new R(true,20000,iOfficalWebService.selectByTitle(officalWeb));
    }

    @GetMapping
    public R getwebsitelist(){
        return new R(true,20000,iOfficalWebService.list());
    }

    @GetMapping("/searchById/{id}")
    public R getwebsiteByid(@PathVariable Integer id){
        return new R(true,20000,iOfficalWebService.getById(id));
    }
}
