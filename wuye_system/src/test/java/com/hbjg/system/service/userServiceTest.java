package com.hbjg.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbjg.system.pojo.User;
import com.hbjg.system.pojo.UserListDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class userServiceTest {

    @Autowired
    private IUserService iUserService;

    @Test
    public void getAll(){
        List<User> userList = iUserService.list();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void queryList(){
        List<User> userList = iUserService.queryList();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void getUserByIdAndPwd(){
        User zhangsan = iUserService.getUserByUsernameAndPwd("zhangsan", "123456");
        System.out.println("用户===》》"+zhangsan);
    }

    @Test
    public void getByPage(){
        IPage<User> page = iUserService.getByPage(1, 3);
        //数据
        System.out.println("getRecords====>"+page.getRecords());
        //当前页数
        System.out.println("getCurrent====>"+page.getCurrent());
        //总页数
        System.out.println("getPages====>"+page.getPages());
        //总条数
        System.out.println("getTotal====>"+page.getTotal());
        //每页显示数
        System.out.println("getSize====>"+page.getSize());
    }

    @Test
    public void save(){
        User user = new User();
        user.setUsername("fengjiu");
        user.setName("冯九");
        user.setPassword("123456");

        boolean save = iUserService.save(user);
        System.out.println("flag："+save);
    }

    @Test
    public void update(){
        User user = new User();
        user.setUsername("chengshi");
        user.setName("陈十");
        user.setPassword("123456");

        boolean b = iUserService.updateById(user);
        System.out.println("操作:"+b);
    }

    @Test
    public void delete(){
        boolean b = iUserService.removeById(12);
        System.out.println(b);
    }

    @Test
    public void getMyPage(){
        User user =  new User();
        user.setName("三");
        user.setUsername("s");
        user.setPhone("1");

        IPage<UserListDto> page = iUserService.getUserMyPage(1,1, user);
        System.out.println(page);
    }

    @Test
    public void test001(){

    }

}
