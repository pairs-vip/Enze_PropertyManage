package com.hbjg.system.controller;


import com.hbjg.system.controller.utils.R;
import com.hbjg.system.pojo.Backlog;
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
    @GetMapping
    public R getAll(){
        return new R(true,iBacklogService.list());
    }

    //新增退库纪录
    @PostMapping
    public R saveBacklog(@RequestBody Backlog backlog){
        return new R(true,iBacklogService.save(backlog));
    }
}
