package com.shawn;

import com.shawn.mapper.UserMapper;
import com.shawn.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// springboot整合单元测试的注解
@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testListUser() {
        List<User> userList = userMapper.list();
        userList.stream().forEach(user -> System.out.println(user));
    }

    /*
    JDBC:(Java DataBase Connectivity)，就是使用Java语言操作关系型数据库的一套API，仅仅是一套接口（规范），并没有提供具体的实现
    关系型数据库产品有很多，不同的数据库底层实现差异较大，操作方式也不同，
    各个数据库厂商提供实现，数据库底层实现各个厂商最清楚，所以由各个厂商提供
    面向接口编程，使用JDBC提供的接口即可
    各个厂商提供的JDBC的实现也叫数据库驱动

    各个数据库厂商去实现这套接口，提供数据库驱动jar包
    真正执行的代码是驱动jar包中的实现类
     */
    @Test
    public void testJdbc() throws Exception {
        // 1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2. 获取连接对象
        String url = "jdbc:mysql://localhost:3306/mybatis";
        String username = "root";
        String password = "3091";
        Connection connection = DriverManager.getConnection(url, username, password);

        // 3. 获取执行SQL的对象Statement，执行SQL，返回结果
        String sql = "select * from user";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        // 4. 封装结果数据
        // 解析resultSet，一个字段一个字段地解析
        List<User> userList = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            short age = resultSet.getShort("age");
            short gender = resultSet.getShort("gender");
            String phone = resultSet.getString("phone");

            User user = new User(id, name, age, gender, phone);
            userList.add(user);
        }

        // 5. 释放资源
        statement.close();
        connection.close();

        userList.stream().forEach(System.out::println);
    }
    /*
    原始的JDBC的弊端
    1. 硬编码：注册驱动和获取连接在开发过程中容易变动 特别是url,username,password
    我们在开发阶段连接开发数据库，测试阶段连接测试数据库，在生产阶段连接生产数据库
    原始JDBC将其写死在Java代码中，一旦发生变化，需要重新编译打包才能运行

    mybatis如何解决：直接操作配置文件就行application.properties

    2. 解析结果繁琐：一般一张表20,30个字段都比较正常，获取结果集繁琐且臃肿

    mybatis如何解决：查询返回的结果封装到User对象当中，整个过程自动化进行

    3. 频繁获取连接和释放连接会导致资源浪费：执行sql语句之前需要获取连接，sql语句执行完毕后马上就关闭了，造成系统性能降低

    mybatis如何解决：application.properties所有的配置项前缀都是spring.datasource
    当我们按照这种方式配置数据库连接信息之后，spring底层会自动采用数据库连接池技术统一管理和分配连接，
    这个连接就是Connection对象
     */
}
