package com.hbjg.system.controller;


import com.hbjg.system.controller.utils.R;
import com.hbjg.system.pojo.Purchaselog;
import com.hbjg.system.service.IPurchaselogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/purchaselogs")
public class PurchaselogController {

    @Autowired
    private IPurchaselogService iPurchaselogService;

    //添加采购纪录
    @PostMapping
    public R savePurchaselog(@RequestBody Purchaselog purchaselog){
        return new R(true,iPurchaselogService.save(purchaselog));
    }

    //查询纪录
    @GetMapping
    public R getAll(){
        return new R(true,iPurchaselogService.list());
    }
}
