package com.hbjg.system.controller;


import com.hbjg.system.utils.R;
import com.hbjg.system.pojo.Storageitems;
import com.hbjg.system.service.IStorageitemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/storageitems")
public class StorageitemsController {

    @Autowired
    private IStorageitemsService iStorageitemsService;

    //查看仓库
    @GetMapping
    public R getAll(){
        return new R(true,20000,iStorageitemsService.list());
    }

    //新增仓库
    @PostMapping
    public R save(@RequestBody Storageitems storageitems){
        return new R(true,20000,iStorageitemsService.save(storageitems));
    }

    //修改仓库
    @PutMapping
    public R update(@RequestBody Storageitems storageitems){
        return new R(true,20000,iStorageitemsService.updateById(storageitems));
    }
    //删除仓库
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){
        return new R(true,20000,iStorageitemsService.removeById(id));
    }
}
