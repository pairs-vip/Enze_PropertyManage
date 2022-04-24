package com.hbjg.system.controller;

import com.hbjg.system.utils.R;
import com.hbjg.system.pojo.*;
import com.hbjg.system.service.IWarehousinglogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/warehousinglogs")
public class WarehousinglogController {


    @Autowired
    private IWarehousinglogService iWarehousinglogService;
    //分页查询入库纪录
    //currentPage为当前页码，pageSize为每页显示数
    //Warehousinglog类对象中自动装填参数通过json发送过来 json的键要和实体类属性名对应
    @PostMapping("/{currentPage}/{pageSize}")
    public R getWlogMyPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize, @RequestBody Condition condition){
        return new R(true,20000,iWarehousinglogService.selectWlogMyPage(currentPage,pageSize,condition));
    }

    //新增添加入库纪录
    @PostMapping
    public R saveWlog(@RequestBody Warehousinglog warehousinglog){
//        System.out.println(warehousinglog);
//        return new R(true,20000,warehousinglog);
        return new R(true,20000,iWarehousinglogService.save(warehousinglog));

    }
}
