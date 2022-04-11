package com.hbjg.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbjg.system.controller.utils.R;
import com.hbjg.system.pojo.A;
import com.hbjg.system.pojo.User;
import com.hbjg.system.pojo.UserListDto;
import com.hbjg.system.service.IUserService;
import com.sun.org.apache.xpath.internal.axes.PredicatedNodeTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import javax.servlet.http.HttpSession;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private IUserService iUserService;

    //查询所有
    @GetMapping()
    public R getAll(){
        return new R(true,iUserService.list());
    }

    //根据username和password查询
    //登录
    @GetMapping("/login/{username}/{password}")
    public R login(@PathVariable String username, @PathVariable String password, HttpSession session){
        User user = iUserService.getUserByUsernameAndPwd(username, password);
        if(user!=null){
            //将当前登录用户存到session中
            session.setAttribute("user",user);
            return new R(true,user);
        }else{
            return new R(true,"用户不存在");
        }
    }
    //注销操作
    @GetMapping("/exit")
    public R exit(HttpSession session){
        session.removeAttribute("user");
        return new R(true,"退出成功");
    }


    //根据username或者id查询
    @GetMapping("/{UsernameOrId}")
    public R getOneByUsername(@PathVariable String UsernameOrId){

        if(UsernameOrId.matches(".*[a-zA-Z].*")){
            return new R(true,iUserService.getByUsername(UsernameOrId));
        }else{
            return new R(true,iUserService.getById(UsernameOrId));

        }
    }
      //分页查询
//    @GetMapping("/getPage/{currentPage}/{pageSize}")
//    public R getByPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
//        return new R(true,iUserService.getByPage(currentPage,pageSize));
//    }

    //添加操作
    @PostMapping
    public R save(@RequestBody User user){
        return new R(iUserService.save(user));
    }

    //修改职位
    @PutMapping("/updateRole/{uid}/{rid}")
    public R updateRole(@PathVariable Integer uid,@PathVariable Integer rid ){
        return new R(iUserService.updateRole(uid,rid));
    }

    //更新操作
    @PutMapping
    public R update(@RequestBody User user){
        return new R(iUserService.updateById(user));
    }

    //根据id删除
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){
        return new R(iUserService.removeById(id));
    }

    //分页查询，带条件，多表查询
    @GetMapping("/{currentPage}/{pageSize}")
    public R getMyPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize,User user){

        IPage<UserListDto> page = iUserService.getUserMyPage(currentPage,pageSize,user);
        if(currentPage > page.getPages()){
            page = iUserService.getUserMyPage((int)page.getPages(),pageSize,user);
        }
        return new R(true,page);
    }

    //前端测试登录
    @GetMapping("/doLogins")
    public R loLogins(){
        System.out.println("shoudao.........");
        A a =new A();
        a.setToken("admin");
        return new R(true,20000,a);
    }
    //测试信息获取
    @GetMapping("/getInfo")
    public R getInfo(){
        System.out.println("shoudao1 ................");
        A a =new A();
        a.setRoles("[admin]");
        a.setIntroduction("I am a super administrator");
        a.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        a.setName("super admin");
        return  new R(true,20000,a);
    }
}
