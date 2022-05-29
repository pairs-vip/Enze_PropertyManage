package com.hbjg.system.controller;


import com.hbjg.system.utils.R;
import com.hbjg.system.pojo.Role;
import com.hbjg.system.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private IRoleService iRoleService;

    //查看所有职位
    @GetMapping
    public R getAll(){
        return new R(true,20000,iRoleService.list());
    }

    //新增职位
    @PostMapping
    public R save(@RequestBody Role role){
        return new R(true,20000,iRoleService.save(role));
    }

    //修改职位
    @PutMapping
    public R update(@RequestBody Role role){
        return new R(true,20000,iRoleService.updateById(role));
    }

    //根据id删除职位
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){
        return new R(true,20000,iRoleService.removeById(id));
    }
}
