package com.hbjg.system.service;

import com.hbjg.system.pojo.Storageitems;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class storageitemsServiceTest {

    @Autowired
    private IStorageitemsService iStorageitemsService;

    @Test
    public void getAll(){
        List<Storageitems> list = iStorageitemsService.list();
        System.out.println(list);
    }
}
