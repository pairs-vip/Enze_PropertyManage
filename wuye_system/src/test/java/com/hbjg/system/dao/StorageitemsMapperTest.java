package com.hbjg.system.dao;


import com.hbjg.system.mapper.StorageitemsMapper;
import com.hbjg.system.pojo.Storageitems;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StorageitemsMapperTest {


    @Autowired
    private StorageitemsMapper storageitemsMapper;

    @Test
    public void getAll(){
        List<Storageitems> storageitems = storageitemsMapper.selectList(null);
        System.out.println(storageitems);
    }
}
