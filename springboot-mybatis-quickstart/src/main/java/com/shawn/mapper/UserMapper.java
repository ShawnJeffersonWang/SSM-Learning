package com.shawn.mapper;

import com.shawn.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// 在运行时，会自动生成该接口的实现类对象(动态代理技术生成的代理对象)，并且将该对象交给IOC容器管理
// maven项目结构，单元测试代码应该写在test目录下
@Mapper
public interface UserMapper {

    // 查询全部用户信息
    @Select("select * from user")
    public List<User> list();
}
