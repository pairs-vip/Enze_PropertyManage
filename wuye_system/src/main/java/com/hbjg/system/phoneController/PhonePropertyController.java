package com.hbjg.system.phoneController;


import com.hbjg.system.utils.R;
import com.hbjg.system.pojo.Property;
import com.hbjg.system.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/phonepropertys")
public class PhonePropertyController {

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
//    @PutMapping("/addpro")
//    public R save(@RequestBody Property property){
//        Property pro = iPropertyService.getProByNameAndSpec(property.getPname(),property.getSpec());
//        if(pro==null){
//            return new R(true,iPropertyService.save(property));
//        }else{
//            Property property1 = iPropertyService.getProByNameAndSpecAndType(property.getPname(),property.getSpec(),property.getType(),property.getType2());
//            if(property1!=null){
//                return new R(true,iPropertyService.addNum(property1.getPid(),property.getNumber()));
//            }else{
//                return new R(true,"此物品已存在，请检查物品类型是否有问题！");
//            }
//        }
//
//    }

    //通过id删除物资
//    @DeleteMapping("/{id}")
//    public R delete(@PathVariable Integer id){
//        return new R(true,20000,iPropertyService.removeById(id));
//    }


    //根据id修改物资
//    @PutMapping
//    public R update(@RequestBody Property property){
//        return new R(true,20000,iPropertyService.updateById(property));
//    }

    //根据id出库物资
//    @PutMapping("/subpro")
//    public R subNum(@RequestBody Property property){
//        //根据名字和规格查看是否存在此物品
//        Property pro = iPropertyService.getProByNameAndSpec(property.getPname(), property.getSpec());
//        if(pro!=null){
//            if(pro.getNumber()<property.getNumber()){
//                return new R(true,"商品库存小于出库数量，请检查");
//            }else{
//                return new R(true,iPropertyService.subNum(pro.getPid(),property.getNumber()));
//            }
//        }else{
//            return new R(true,20000,"仓库中不存在此物品，请检查");
//        }
//    }

}
