package com.hbjg.system.phoneController;


import com.hbjg.system.utils.R;
import com.hbjg.system.pojo.Lendlog;
import com.hbjg.system.pojo.User;
import com.hbjg.system.service.ILendlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

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
            lendlog.setUserId1(user.getId());
        }
        return new R(true,20000,iLendlogService.save(lendlog));
    }

    //根据一个列表生成租借纪录
    @PostMapping("/savelendlogs")
    public R saveLendlogs(@RequestBody List<Lendlog> lendlogs,HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user!=null){
            for (Lendlog lendlog : lendlogs) {
                lendlog.setUserId1(user.getId());
                iLendlogService.save(lendlog);
            }
        }
        return new R(true,20000,"借出纪录添加成功");
    }

    //通过当前用户查看,查看当前登录用户的借出纪录
    @PostMapping("/getforuser1/{currentPage}/{pageSize}")
    public R getLendForUser1(@PathVariable Integer currentPage, @PathVariable Integer pageSize, HttpSession session, @RequestBody Lendlog lendlog){
        User user = (User)session.getAttribute("user");
        System.out.println("sesssioncontroller:"+user);
        return new R(true,20000,iLendlogService.getLendForUser1(currentPage,pageSize,lendlog,session));
    }

}
