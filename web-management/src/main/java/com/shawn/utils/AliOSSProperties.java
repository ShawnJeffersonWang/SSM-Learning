package com.shawn.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
@ConfigurationProperties与@Value都是用来注入外部配置的属性的
@Value注解只能一个一个的进行外部属性的注入
@ConfigurationProperties可以批量的将外部的属性配置注入到bean对象的属性中
 */
@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliOSSProperties {

    private String endpoint;
    private String bucketName;
}
