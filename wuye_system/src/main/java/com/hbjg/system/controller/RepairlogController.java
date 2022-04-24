package com.hbjg.system.controller;


import com.hbjg.system.pojo.Repairlog;
import com.hbjg.system.service.IRepairlogService;
import com.hbjg.system.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/repairlogs")
public class RepairlogController {

    @Autowired
    private IRepairlogService iRepairlogService;

    //查看所有纪录分页
    @PostMapping("/{currentPage}/{pageSize}")
    public R getReplogMyPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
        return new R(true,20000,iRepairlogService.getReplogMyPage(currentPage,pageSize));
    }

    //新增维修
    @PostMapping
    public R save(@RequestBody Repairlog repairlog){
        return new R(true,20000,iRepairlogService.save(repairlog));
    }

    //维修完成
    //修改维修纪录
    @PutMapping
    public R update(@RequestBody Repairlog repairlog){
        return new R(true,20000,iRepairlogService.updateById(repairlog));
    }

    //删除维修纪录  ！！！慎重
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){
        return new R(true,20000,iRepairlogService.removeById(id));
    }
}
