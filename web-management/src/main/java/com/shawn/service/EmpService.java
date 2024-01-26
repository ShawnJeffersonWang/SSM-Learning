package com.shawn.service;

import com.shawn.pojo.PageBean;

public interface EmpService {

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer pageSize);
}
