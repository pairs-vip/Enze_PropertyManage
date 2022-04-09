package com.hbjg.system.controller;


import com.hbjg.system.controller.utils.R;
import com.hbjg.system.pojo.Role;
import com.hbjg.system.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private IRoleService iRoleService;

    @GetMapping
    public R getAll(){
        return new R(true,iRoleService.list());
    }

    @PostMapping
    public R save(@RequestBody Role role){
        return new R(true,iRoleService.save(role));
    }

    @PutMapping
    public R update(@RequestBody Role role){
        return new R(true,iRoleService.updateById(role));
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){
        return new R(true,iRoleService.removeById(id));
    }
}
