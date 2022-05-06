package com.hbjg.system.controller;

import com.hbjg.system.utils.R;
import com.hbjg.system.pojo.Condition;
import com.hbjg.system.pojo.Lendlog;
import com.hbjg.system.pojo.Returnlog;
import com.hbjg.system.service.ISlrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/slrs")
public class SlrController {

    @Autowired
    private ISlrService iSlrService;

    //汇总表，查看当前有哪些资产被谁借走了多少等
//    @PostMapping("/{currentPage}/{pageSize}")
//    public R getSlrMyPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize, @RequestBody Condition condition){
//       return new R(true,20000,iSlrService.selectSlrMyPage(currentPage,pageSize,condition));
//    }

    //汇总表，查看当前有哪些资产被谁借走了多少等
    @PostMapping("/{currentPage}/{pageSize}")
    public R getSlrMyPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize, @RequestBody Condition condition){
       return new R(true,20000,iSlrService.selectSlrMyPage(currentPage,pageSize,condition));
    }

    //查看当前项目的负责人是否将东西全部归还
    @GetMapping("/checkIsNull/{userId}")
    public R getSlrByUserId(@PathVariable Integer userId){
        return new R(true,20000,iSlrService.selectSlrByUserId(userId));
    }

    //每次借出通过审核就要进行修改汇总表
    @PutMapping("/lend")
    public R AddNumber(@RequestBody Lendlog lendlog){
        return new R(true,20000,iSlrService.AddNumByUidAndPid(lendlog));
    }

    //每次归还通过审核也要进行修改汇总表
    @PutMapping("/return")
    public R SubNumber(@RequestBody Returnlog returnlog){
        return new R(true,20000,iSlrService.SubNumByUidAndPid(returnlog));
    }

}
