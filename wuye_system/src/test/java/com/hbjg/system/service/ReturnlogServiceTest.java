package com.hbjg.system.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hbjg.system.controller.utils.R;
import com.hbjg.system.pojo.Returnlog;
import com.hbjg.system.pojo.ReturnlogListDto;
import com.sun.org.apache.regexp.internal.RE;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReturnlogServiceTest {


    @Autowired
    private IReturnlogService iReturnlogService;

    @Test
    public void test01(){
        Returnlog returnlog = new Returnlog();
        iReturnlogService.getReturnlogMyPage(1,10,returnlog);
    }
}
