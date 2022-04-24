package com.hbjg.system.phoneController;


import com.hbjg.system.utils.JwtUtil;
import com.hbjg.system.utils.R;
import com.hbjg.system.pojo.User;
import com.hbjg.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/phoneusers")
public class PhoneUserController {


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
                //添加头像
                user.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
                //登录成功，添加token
                user.setToken(JwtUtil.createToken());
                //将当前登录用户存到session中,然后返回给前端
                session.setAttribute("user",user);
                return new R(true,20000,user);
            } else{
            return new R(true,20000,"用户名或密码错误！");
        }
    }
    //验证token
    @GetMapping("/checkToken")
    public R checkToken(HttpServletRequest request){
        String token = request.getHeader("token");
        return new R(true,20000,JwtUtil.checkToken(token));
    }
    //注销操作
    @GetMapping("/exit")
    public R exit(HttpSession session){
        session.removeAttribute("user");
        return new R(true,"退出成功");
    }


    //根据username或者id查询
//    @GetMapping("/{UsernameOrId}")
//    public R getOneByUsername(@PathVariable String UsernameOrId){
//
//        if(UsernameOrId.matches(".*[a-zA-Z].*")){
//            return new R(true,iUserService.getByUsername(UsernameOrId));
//        }else{
//            return new R(true,iUserService.getById(UsernameOrId));
//
//        }
//    }
      //分页查询
//    @GetMapping("/getPage/{currentPage}/{pageSize}")
//    public R getByPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
//        return new R(true,iUserService.getByPage(currentPage,pageSize));
//    }

    //添加操作
//    @PostMapping
//    public R save(@RequestBody User user){
//        return new R(iUserService.save(user));
//    }

    //修改职位
//    @PutMapping("/updateRole/{uid}/{rid}")
//    public R updateRole(@PathVariable Integer uid,@PathVariable Integer rid ){
//        return new R(iUserService.updateRole(uid,rid));
//    }

    //更新操作
    @PutMapping
    public R update(@RequestBody User user){
        return new R(iUserService.updateById(user));
    }

    //根据id删除
//    @DeleteMapping("/{id}")
//    public R delete(@PathVariable Integer id){
//        return new R(iUserService.removeById(id));
//    }

    //分页查询，带条件，多表查询
//    @GetMapping("/{currentPage}/{pageSize}")
//    public R getMyPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize,User user){
//
//        IPage<UserListDto> page = iUserService.getUserMyPage(currentPage,pageSize,user);
//        if(currentPage > page.getPages()){
//            page = iUserService.getUserMyPage((int)page.getPages(),pageSize,user);
//        }
//        return new R(true,page);
//    }
}
