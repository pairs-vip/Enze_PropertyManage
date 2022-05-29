package com.hbjg.system.dao;


import com.hbjg.system.mapper.PropertyMapper;
import com.hbjg.system.pojo.Property;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PropertyMapperTest {

    @Autowired
    private PropertyMapper propertyMapper;

    @Test
    public void test01(){

        Property property = new Property();
        property.setName("书本");
        property.setNumber(23);
        property.setRemark("教师专用");

        System.out.println(property);
    }
}
