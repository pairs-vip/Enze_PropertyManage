package com.hbjg.system.dao;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbjg.system.mapper.UserMapper;
import com.hbjg.system.pojo.User;
import com.hbjg.system.pojo.UserListDto;
import jdk.nashorn.internal.ir.CallNode;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class userMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getAll(){
        List<User> userList = userMapper.selectList(null);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void querytest(){
        //List<User> maps = userMapper.queryTest();
        //for (User map : maps) {
       //     System.out.println(map);
       // }
    }

    @Test
    public void getUserByIdAndPwd(){
        User zhangsan = userMapper.findUserByUsernameAndPwd("zhangsan", "123456");
        System.out.println("用户===========>"+zhangsan);

    }

    @Test
    public void  getUserByUsername(){
        User zhangsan = userMapper.findUserByUsername("zhangsan");
        System.out.println("用户------->"+zhangsan);
    }

    @Test
    public void getByPage(){
        IPage<User> page = new Page<>(2,3);
        page = userMapper.selectPage(page, null);
        System.out.println(page);
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
    public void save() {
        User user = new User();
        user.setUsername("fengjiu");
        user.setName("冯九");
        user.setPassword("123456");

        int insert = userMapper.insert(user);
        System.out.println("操作:"+insert);
    }

    @Test
    public void getMyPage(){
        User user =  new User();
        user.setName("三");
        user.setUsername("s");
        user.setPhone("1");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(user.getUsername())) {
            queryWrapper.like("tb_user.username", user.getUsername());
        }

        if (StringUtils.isNotBlank(user.getName())) {
            queryWrapper.like("tb_user.name", user.getName());
        }
        if (Strings.isNotBlank(user.getPhone())){
            queryWrapper.like("tb_user.phone",user.getPhone());
        }

        IPage<UserListDto> page = new Page<>(2,1);

        page = userMapper.selectUserMyPage(page,queryWrapper);
        System.out.println(page);
    }

}
