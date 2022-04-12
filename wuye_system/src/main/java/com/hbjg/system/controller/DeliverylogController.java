package com.hbjg.system.controller;


import com.hbjg.system.controller.utils.R;
import com.hbjg.system.pojo.Condition;
import com.hbjg.system.pojo.Deliverylog;
import com.hbjg.system.pojo.DeliverylogListDto;
import com.hbjg.system.service.IDeliverylogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/deliverylogs")
public class DeliverylogController {

    @Autowired
    private IDeliverylogService iDeliverylogService;

    //分页查询出库纪录
    //currentPage为当前页码，pageSize为每页显示数
    //Delivertylog类对象中自动装填参数通过json发送过来 json的键要和实体类属性名对应
    @GetMapping("/{currentPage}/{pageSize}")
    public R getDlogMyPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize, @RequestBody Condition condition){
        return new R(true,iDeliverylogService.selectDlogMyPage(currentPage,pageSize,condition));
    }

    //新增添加出库纪录
    @PostMapping
    public R saveDlog(@RequestBody Deliverylog deliverylog){
        return new R(true,iDeliverylogService.save(deliverylog));
    }
}
