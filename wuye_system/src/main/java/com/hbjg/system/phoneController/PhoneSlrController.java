package com.hbjg.system.phoneController;

import com.hbjg.system.controller.utils.R;
import com.hbjg.system.pojo.Condition;
import com.hbjg.system.pojo.Lendlog;
import com.hbjg.system.pojo.Returnlog;
import com.hbjg.system.service.ISlrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/phoneslrs")
public class PhoneSlrController {

    @Autowired
    private ISlrService iSlrService;

    //汇总表，查看当前登录用户未归还资产名称及数量
    @PostMapping("/{currentPage}/{pageSize}")
    public R getSlrMyPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize, @RequestBody Condition condition, HttpSession session){
       return new R(true,iSlrService.selectSlrMyPageForUser(currentPage,pageSize,condition,session));
    }

    //每次借出通过审核就要进行修改汇总表
    @PutMapping("/lend")
    public R AddNumber(@RequestBody Lendlog lendlog){
        return new R(true,iSlrService.AddNumByUidAndPid(lendlog));
    }

    //每次归还通过审核也要进行修改汇总表
    @PutMapping("/return")
    public R SubNumber(@RequestBody Returnlog returnlog){
        return new R(true,iSlrService.SubNumByUidAndPid(returnlog));
    }

}
