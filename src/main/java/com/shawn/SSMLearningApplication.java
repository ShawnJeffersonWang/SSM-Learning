package com.shawn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
SpringBoot项目的静态资源(html,css,js等前端资源)
默认存放目录为：classpath:/static,classpath:/public,classpath:/resources

Bean组件扫描
前面声明bean的四大注解，要想生效，还需要被组件扫描注解@ComponentScan扫描
@ComponentScan注解虽然没有显示配置，但是实际上已经包含在了启动类声明注解@SpringBootApplication中，
默认扫描的范围是启动类所在包及其子包
 */
@SpringBootApplication
public class SSMLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(SSMLearningApplication.class, args);
	}

}
