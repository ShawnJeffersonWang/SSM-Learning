package com.shawn.service.impl;

import com.shawn.dao.EmpDao;
import com.shawn.dao.impl.EmpDaoA;
import com.shawn.pojo.Emp;
import com.shawn.service.EmpService;

import java.util.List;

public class EmpServiceA implements EmpService {

    // 面向接口编程，直接用EmpDao
    private EmpDao empDao=new EmpDaoA();
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
            String gender=emp.getGender();
            if("1".equals(gender)){
                emp.setGender("男");
            }else if("2".equals(gender)){
                emp.setGender("女");
            }

            String job=emp.getJob();
            if("1".equals(job)){
                emp.setJob("讲师");
            }else if("2".equals(job)){
                emp.setJob("班主任");
            }else if ("3".equals(job)){
                emp.setJob("就业指导");
            }
        });
        return empList;
    }
}
