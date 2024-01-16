package com.shawn.dao.impl;

import com.shawn.dao.EmpDao;
import com.shawn.pojo.Emp;
import com.shawn.utils.XmlParserUtils;

import java.util.List;

public class EmpDaoA implements EmpDao {

    @Override
    public List<Emp> listEmp() {
        String file=this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList= XmlParserUtils.parse(file,Emp.class);
        return empList;
    }
}
