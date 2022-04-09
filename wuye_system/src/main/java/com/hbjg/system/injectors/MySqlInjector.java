package com.hbjg.system.injectors;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;

import java.util.ArrayList;
import java.util.List;

public class MySqlInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {

        List<AbstractMethod> list = new ArrayList<>();
        list.addAll(super.getMethodList(mapperClass));

        list.add(new FindUserByUsernameAndPwd());
        list.add(new FindUserByUsername());
        return list;

    }
}
