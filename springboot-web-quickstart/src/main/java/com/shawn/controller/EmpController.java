package com.shawn.controller;

// Controller不负责逻辑处理
// Controller只负责接受请求，响应数据

import com.shawn.pojo.Employee;
import com.shawn.pojo.Result;
import com.shawn.service.EmpService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 已经交给了IOC容器管理
@RestController
public class EmpController {

    //    private EmpService empService = new EmpServiceA();
    // 这样运行会报空指针异常
    // 运行时，IOC容器会提供该类型的bean对象，并赋值给该变量-依赖注入
    // @Autowired注解，默认是按照类型进行，如果存在多个相同类型的bean，将会报出如下错误
    // 默认类名首字母小写
//    @Qualifier("empServiceA")
//    @Autowired
//    private EmpService empService;

    // @Resource由jdk提供
    @Resource(name = "empServiceA")
    private EmpService empService;

    // 调用Service获取数据
    @RequestMapping("/listEmp")
    public Result list() {
        List<Employee> empList = empService.listEmp();
        return Result.success(empList);
    }
}

/*
控制反转：Inversion Of Control，简称IOC。对象的创建控制权由程序自身转移到外部（容器），这中思想称为控制反转。
依赖注入：Dependency Injection，简称DI。容器为应用程序提供运行时，所依赖的资源，称之为依赖注入
Bean对象：IOC容器中创建，管理的对象，称之为bean

面试题：
@Resource与@Autowired区别
@Autowired是spring框架提供的注解，而@Resource是JDK提供的注解
@Autowired默认是按照类型注入，@Resource默认是按照名称注入
 */