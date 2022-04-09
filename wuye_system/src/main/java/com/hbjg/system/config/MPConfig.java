package com.hbjg.system.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.hbjg.system.injectors.MySqlInjector;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.hbjg.system.mapper")
public class MPConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        //1.定义MP拦截器
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //2.添加具体得拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }

    @Bean
    public MySqlInjector mySqlInjector(){
        return new MySqlInjector();
    }
}

