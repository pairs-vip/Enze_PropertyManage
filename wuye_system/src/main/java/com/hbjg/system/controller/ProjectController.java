package com.hbjg.system.controller;

import com.hbjg.system.pojo.Project;
import com.hbjg.system.service.IProjectService;
import com.hbjg.system.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private IProjectService iProjectService;

    //获取当前系统中存在的项目及其负责人
    @GetMapping
    public R getAll(){
        return new R(true,20000,iProjectService.selectAll());
    }

    //新增项目
    @PostMapping
    public R save(@RequestBody Project project){
        return new R(true,20000,iProjectService.save(project));
    }

    //删除项目
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){
        return new R(true,20000,iProjectService.removeById(id));
    }
}
