package com.hbjg.system.controller;


import com.hbjg.system.utils.R;
import com.hbjg.system.pojo.Department;
import com.hbjg.system.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private IDepartmentService iDepartmentService;

    //查看所有部门
    @GetMapping
    public R getAll(){
        return new R(true,20000,iDepartmentService.list());
    }

    //新增部门
    @PostMapping
    public R save(@RequestBody Department department){
        return new R(true,20000,iDepartmentService.save(department));
    }

    //修改部门
    @PutMapping
    public R update(@RequestBody Department department){
        return new R(true,20000,iDepartmentService.updateById(department));
    }


    //根据id删除部门
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){
        return new R(true,20000,iDepartmentService.removeById(id));
    }
}
