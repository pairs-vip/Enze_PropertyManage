package com.hbjg.system.controller;


import com.hbjg.system.controller.utils.R;
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

    @GetMapping
    public R getAll(){
        return new R(true,20000,iStorageitemsService.list());
    }

    @PostMapping
    public R save(@RequestBody Storageitems storageitems){
        return new R(true,20000,iStorageitemsService.save(storageitems));
    }

    @PutMapping
    public R update(@RequestBody Storageitems storageitems){
        return new R(true,20000,iStorageitemsService.updateById(storageitems));
    }


    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){
        return new R(true,20000,iStorageitemsService.removeById(id));
    }
}
