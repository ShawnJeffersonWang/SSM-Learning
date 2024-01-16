package com.shawn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
SpringBoot项目的静态资源(html,css,js等前端资源)
默认存放目录为：classpath:/static,classpath:/public,classpath:/resources
 */
@SpringBootApplication
public class SSMLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(SSMLearningApplication.class, args);
	}

}
