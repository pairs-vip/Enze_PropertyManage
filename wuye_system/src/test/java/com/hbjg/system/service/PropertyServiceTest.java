package com.hbjg.system.service;


import com.hbjg.system.pojo.Property;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PropertyServiceTest {


    @Autowired
    private IPropertyService iPropertyService;

    @Test
    public void getpagetest(){
        Property property = new Property();
        property.setPname("鼠");
//        property.setType(2);
        iPropertyService.getProMyPage(2,2,property);
    }

    @Test
    public void test02(){
        System.out.println(iPropertyService.getById(2));
    }
}
