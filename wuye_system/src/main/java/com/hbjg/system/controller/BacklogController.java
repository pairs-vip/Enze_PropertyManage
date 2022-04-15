package com.hbjg.system.controller;


import com.hbjg.system.controller.utils.R;
import com.hbjg.system.pojo.Backlog;
import com.hbjg.system.pojo.Condition;
import com.hbjg.system.service.IBacklogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/backlogs")
public class BacklogController {

    @Autowired
    private IBacklogService iBacklogService;


    //查看所有退库纪录
    @PostMapping("/{currentPage}/{pageSize}")
    public R getBacklogMyPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize, @RequestBody Condition condition){
        return new R(true,20000,iBacklogService.selectBacklogMyPage(currentPage,pageSize,condition));
    }

    //新增退库纪录
    @PostMapping
    public R saveBacklog(@RequestBody Backlog backlog){
        return new R(true,20000,iBacklogService.save(backlog));
    }

    //修改退库信息
    @PutMapping
    public R updateBacklog(@RequestBody Backlog backlog){
        return new R(true,20000,iBacklogService.updateById(backlog));
    }

    //删除退库信息
    @DeleteMapping("/{id}")
    public R deleteBacklog(@PathVariable  Integer id){
        return new R(true,20000,iBacklogService.removeById(id));
    }
}

