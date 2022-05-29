package com.hbjg.system.controller;


import com.hbjg.system.pojo.*;
import com.hbjg.system.utils.R;
import com.hbjg.system.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/propertys")
public class PropertyController {

    @Autowired
    private IPropertyService iPropertyService;

    //分页查询带参数
    @PostMapping("/{currentPage}/{pageSize}")
    public R getProByPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize,@RequestBody Property property){

        return new R(true,20000,iPropertyService.getProMyPage(currentPage,pageSize,property));
    }

    //查询所有不分页
    @GetMapping
    public R getAll(){
        return new R(true,20000,iPropertyService.list());

    }


    //新增物资
    //新增时检测仓库中是否存在此物品
    @PostMapping("/addpro")
    public R warehousing(@RequestBody Property property){
        Property pro = iPropertyService.getProByNameAndSpec(property.getName(),property.getSpec());
        if(pro==null){
            return new R(true,20000,iPropertyService.save(property));
        }else{
            Property property1 = iPropertyService.getProByNameAndSpecAndType(property.getName(),property.getSpec(),property.getTypeId(),property.getType2Id());
            if(property1!=null){
                return new R(true,20000,iPropertyService.addNum(property1.getId(),property.getNumber()));
            }else{
                return new R(true,20000,"此物品已存在，请检查物品类型是否有问题！");
            }
        }

    }

    //通过id删除物资
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){
        return new R(true,20000,iPropertyService.removeById(id));
    }


    //根据id修改物资
    @PutMapping
    public R update(@RequestBody Property property){
        return new R(true,20000,iPropertyService.updateById(property));
    }

    //根据id出库物资
    @PutMapping("/subpro")
    public R delivery(@RequestBody Property property){
        //根据名字和规格查看是否存在此物品
        Property pro = iPropertyService.getProByNameAndSpec(property.getName(), property.getSpec());
        if(pro!=null){
            if(pro.getNumber()<property.getNumber()){
                return new R(true,20000,"商品库存小于出库数量，请检查");
            }else{
                return new R(true,20000,iPropertyService.subNum(pro.getId(),property.getNumber()));
            }
        }else{
            return new R(true,20000,"仓库中不存在此物品，请检查");
        }
    }

    @RequestMapping("/findById/{id}")
    public R findById(@PathVariable Integer id){
        return new R(true,20000,iPropertyService.getById(id));
    }

    //借出审核通过之后进行资产数量的修改
    @PutMapping("/lendPro")
    public R lendPro(@RequestBody Lendlog lendlog){
        Integer pid = lendlog.getPropertyId();
        Integer number = lendlog.getPropertyNumber();
        return new R(true,20000,iPropertyService.subNum(pid,number));
    }
    //归还审核通过之后进行资产数据量修改
    @PutMapping("/returnPro")
    public R ReturnPro(@RequestBody Returnlog returnlog){
        Integer pid = returnlog.getPropertyId();
        Integer number = returnlog.getPropertyNumber();
        return new R(true,20000,iPropertyService.addNum(pid,number));
    }
    //将资产拿去维修
    @PutMapping("/repair")
    public R repairPro(@RequestBody Repairlog repairlog){
        Integer pid = repairlog.getPropertyId();
        Integer number = repairlog.getNumber();
        return new R(true,20000,iPropertyService.subNum(pid,number));
    }
    //维修完成
    @PutMapping("/repaired")
    public R repairedPro(@RequestBody Repairlog repairlog){
        Integer pid = repairlog.getPropertyId();
        Integer number = repairlog.getNumber();
        return new R(true,20000,iPropertyService.addNum(pid,number));
    }

    //报废
    @PutMapping("/scrap")
    public R scrapPro(@RequestBody Scraplog scraplog){
        Integer pid = scraplog.getPropertyId();
        Integer number = scraplog.getNumber();
        return new R(true,20000,iPropertyService.subNum(pid,number));
    }
}
