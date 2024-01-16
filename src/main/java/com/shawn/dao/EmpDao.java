package com.shawn.dao;

import com.shawn.pojo.Emp;

import java.util.List;

// 数据的访问操作，增删改查
public interface EmpDao {

    // 获取员工列表数据
    public List<Emp> listEmp();
}
