package com.shawn;

import com.shawn.mapper.UserMapper;
import com.shawn.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

// springboot整合单元测试的注解
@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testListUser(){
		List<User> userList=userMapper.list();
		userList.stream().forEach(user-> System.out.println(user));
	}
}
