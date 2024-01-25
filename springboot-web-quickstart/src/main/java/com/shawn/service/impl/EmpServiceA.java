package com.shawn.service.impl;

import com.shawn.dao.EmpDao;
import com.shawn.dao.impl.EmpDaoA;
import com.shawn.pojo.Emp;
import com.shawn.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/*
内聚：软件中各个功能模块内部的功能联系
耦合：衡量软件中各个层、模块之间的依赖，关联的程度
软件设计原则：高内聚低耦合
控制器类-业务类-数据访问类
 */
// 将Service实现类交给IOC容器管理，成为IOC容器中的bean
//@Component
@Service
public class EmpServiceA implements EmpService {

    // 面向接口编程，直接用EmpDao
//    private EmpDao empDao = new EmpDaoA();
    // 运行时，IOC容器会提供该类型的bean对象，并赋值给该变量-依赖注入
    @Autowired
    private EmpDao empDao;

    /*
    没有emplist这个集合
    集合数据从哪来
    Service逻辑处理的数据需要调用DAO来处理
    Service要想调用DAO，就需要创建DAO层的对象
     */
    @Override
    public List<Emp> listEmp() {
        // 1. 调用dao，处理数据
        List<Emp> empList = empDao.listEmp();

        // 2. 对数据进行转换处理-gender，job
        empList.stream().forEach(emp -> {
            String gender = emp.getGender();
            if ("1".equals(gender)) {
                emp.setGender("男");
            } else if ("2".equals(gender)) {
                emp.setGender("女");
            }

            String job = emp.getJob();
            if ("1".equals(job)) {
                emp.setJob("讲师");
            } else if ("2".equals(job)) {
                emp.setJob("班主任");
            } else if ("3".equals(job)) {
                emp.setJob("就业指导");
            }
        });
        return empList;
    }
}

/*
IOC&DI入门
Service层及Dao层的实现类，交给IOC容器管理
为Controller及Service注入运行时，依赖的对象
运行测试
 */
