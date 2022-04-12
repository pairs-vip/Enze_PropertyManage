package com.hbjg.system.controller;


import com.hbjg.system.controller.utils.R;
import com.hbjg.system.pojo.Type;
import com.hbjg.system.pojo.Type2;
import com.hbjg.system.service.IType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/type2s")
public class Type2Controller {

    @Autowired
    private IType2Service iType2Service;

    @GetMapping
    public R getall(){
        return new R(true,iType2Service.list());
    }

    //根据第一分类查找第二分类
    @GetMapping("/getType2/{id}")
    public R getType2ByType(@PathVariable Integer id){
        return new R(true,iType2Service.getType2ByType(id));
    }

    //新增第二分类
    @PostMapping
    public R saveType2(@RequestBody Type2 type2){
        return new R(true,iType2Service.save(type2));
    }
    //修改第二分类
    @PutMapping
    public R updateType2(@RequestBody Type2 type2){
        return new R(true,iType2Service.updateById(type2));
    }

    //删除二级分类
    @DeleteMapping("/{id}")
    public R deleteTyped(@PathVariable Integer id){
        return new R(true,iType2Service.removeById(id));
    }
}
