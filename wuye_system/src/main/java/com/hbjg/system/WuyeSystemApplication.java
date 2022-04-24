package com.hbjg.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class WuyeSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(WuyeSystemApplication.class, args);
    }

}
