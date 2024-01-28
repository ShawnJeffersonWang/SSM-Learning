package com.shawn.service;

import com.shawn.pojo.Emp;
import com.shawn.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin,LocalDate end);

    /**
     * 批量删除
     * @param ids
     */
    void delete(List<Integer> ids);

    /**
     * 新增员工
     * @param emp
     */
    void save(Emp emp);
}
