package com.hbjg.system.phoneController;


import com.hbjg.system.controller.utils.R;
import com.hbjg.system.pojo.Condition;
import com.hbjg.system.pojo.Lendlog;
import com.hbjg.system.pojo.User;
import com.hbjg.system.service.ILendlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/phonelendlogs")
public class PhoneLendlogController {

    @Autowired
    private ILendlogService iLendlogService;

    //查看所有借出纪录分页
//    @GetMapping("/{currentPage}/{pageSize}")
//    public R getLendlogMyPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize,@RequestBody  Condition condition){
//        return new R(true,iLendlogService.getLendlogMyPage(currentPage,pageSize,condition));
//    }

    //用户进行租借物品,然后生成租借纪录
    @PostMapping
    public R saveLendLog(@RequestBody Lendlog lendlog,HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user!=null){
            lendlog.setUid1(user.getUid());
        }
        return new R(true,iLendlogService.save(lendlog));
    }

    //将未同意改为已同意
    @PutMapping
    public R updateStatusByLlid(@RequestBody Lendlog lendlog){
        return new R(true,iLendlogService.updateById(lendlog));
    }
    //通过当前用户查看,查看当前登录用户的借出纪录
    @PostMapping("/getforuser1/{currentPage}/{pageSize}")
    public R getLendForUser1(@PathVariable Integer currentPage, @PathVariable Integer pageSize, HttpSession session, @RequestBody Lendlog lendlog){
        return new R(true,iLendlogService.getLendForUser1(currentPage,pageSize,lendlog,session));
    }
    //通过当前用户查看,查看以自己为审核人的借出纪录
    @PostMapping("/getforuser2/{currentPage}/{pageSize}")
    public R getLendForUser2(@PathVariable Integer currentPage, @PathVariable Integer pageSize, HttpSession session, @RequestBody Lendlog lendlog){
        return new R(true,iLendlogService.getLendForUser2(currentPage,pageSize,lendlog,session));
    }
}
