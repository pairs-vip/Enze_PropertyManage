package com.hbjg.system.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.hbjg.system.controller.utils.R;
import com.hbjg.system.pojo.Deliverylog;
import com.hbjg.system.pojo.DeliverylogListDto;
import com.hbjg.system.pojo.Warehousinglog;
import com.hbjg.system.pojo.WarehousinglogListDto;
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
    @GetMapping("/{currentPage}/{pageSize}")
    public R getWlogMyPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize, @RequestBody WarehousinglogListDto warehousinglogListDto){
        return new R(true,iWarehousinglogService.selectWlogMyPage(currentPage,pageSize,warehousinglogListDto));
    }

    //新增添加入库纪录
    @PostMapping
    public R saveWlog(@RequestBody Warehousinglog warehousinglog){
        return new R(true,iWarehousinglogService.save(warehousinglog));
    }
}
