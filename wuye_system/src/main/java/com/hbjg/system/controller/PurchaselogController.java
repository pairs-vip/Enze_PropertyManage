package com.hbjg.system.controller;


import com.hbjg.system.controller.utils.R;
import com.hbjg.system.pojo.Condition;
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
        return new R(true,20000,iPurchaselogService.save(purchaselog));
    }

    //查询纪录
    @PostMapping("/{currentPage}/{pageSize}")
    public R getPurchaselogMyPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize,@RequestBody Condition condition){
        return new R(true,20000,iPurchaselogService.selectPurlogMyPage(currentPage,pageSize,condition));
    }
    //修改采购信息
    @PutMapping
    public R updatePurchaselog(@RequestBody Purchaselog purchaselog){
        return new R(true,20000,iPurchaselogService.updateById(purchaselog));
    }
    //删除采购信息
    @DeleteMapping("/{id}")
    public R deletePurchaselog(@PathVariable Integer id){
        return new R(true,20000,iPurchaselogService.removeById(id));
    }
}
