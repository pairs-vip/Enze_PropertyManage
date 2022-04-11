package com.hbjg.system.controller;


import com.hbjg.system.controller.utils.R;
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

    @GetMapping("/getType2/{id}")
    public R getType2ByType(@PathVariable Integer id){
        return new R(true,iType2Service.getType2ByType(id));
    }
}
