package com.shawn.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shawn.mapper.EmpMapper;
import com.shawn.pojo.Emp;
import com.shawn.pojo.PageBean;
import com.shawn.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    //    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        Long count = empMapper.count();
//        Integer start = (page - 1) * pageSize;
//        List<Emp> empList = empMapper.page(start, pageSize);
//
//        return new PageBean(count,empList);
//    }
    @Override
    public PageBean page(Integer page, Integer pageSize) {
        // 1. 设置分页参数
        PageHelper.startPage(page,pageSize);

        // 2. 执行查询
        List<Emp> empList = empMapper.list();
        Page<Emp> p=(Page<Emp>) empList;

        // 3. 封装pageBean对象
        return new PageBean(p.getTotal(), p.getResult());
    }
}
