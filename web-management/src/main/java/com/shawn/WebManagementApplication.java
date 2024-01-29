package com.shawn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Filter是JavaWeb三大组件之一，并不是SpringBoot中提供的功能
 * 必须在启动类上加注解
 */
@ServletComponentScan
@SpringBootApplication
public class WebManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebManagementApplication.class, args);
    }

}
