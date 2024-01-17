package com.shawn.dao.impl;

import com.shawn.dao.EmpDao;
import com.shawn.pojo.Emp;
import com.shawn.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

// DAO的实现类交给IOC容器管理，称为IOC容器中的bean，完成控制反转
/*
声明bean的时候，可以通过value属性指定bean的名字，如果没有指定，默认为类名首字母小写
使用以上四个注解都可以声明bean，但是在springboot集成web开发中，声明控制器bean只能用@Controller
 */
//@Component
@Repository(value = "daoA")
public class EmpDaoA implements EmpDao {

    @Override
    public List<Emp> listEmp() {
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
