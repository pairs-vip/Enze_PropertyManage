package com.hbjg.system.controller;

import com.hbjg.system.controller.utils.R;
import com.hbjg.system.pojo.Type;
import com.hbjg.system.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/types")
public class TypeController {

    @Autowired
    private ITypeService iTypeService;

    @GetMapping
    public R getAll(){
        return new R(true,iTypeService.list());
    }

    @PostMapping
    public R save(@RequestBody Type type){
        return new R(true,iTypeService.save(type));
    }

    @PutMapping
    public R update(@RequestBody Type type){
        return new R(true,iTypeService.updateById(type));
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){
        return new R(true,iTypeService.removeById(id));
    }
}
