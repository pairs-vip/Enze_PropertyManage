package com.hbjg.system.controller;


import com.hbjg.system.pojo.Scraplog;
import com.hbjg.system.service.IScraplogService;
import com.hbjg.system.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scraplogs")
public class ScraplogController {

    @Autowired
    private IScraplogService iScraplogService;

    //查看所有的报废纪录
    @PostMapping("/{currentPage}/{pageSize}")
    public R getScrlogMyPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
        return new R(true,20000,iScraplogService.getScrlogMyPage(currentPage,pageSize));
    }

    //新增报废纪录
    @PostMapping
    public R save(@RequestBody Scraplog scraplog){
        return new R(true,20000,iScraplogService.save(scraplog));
    }
}
