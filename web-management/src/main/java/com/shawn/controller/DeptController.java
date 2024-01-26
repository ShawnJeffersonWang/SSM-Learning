package com.shawn.controller;

import com.shawn.pojo.Dept;
import com.shawn.pojo.Result;
import com.shawn.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 * 一个完整的请求路径，应该是类上的@RequestMapping的value属性+ 方法上的@RequestMapping的value属性
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    // lombok简化了定义日志对象
//    private static Logger log= LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    // 指定请求方式为GET

    /**
     * 查询部门数据
     *
     * @return
     */
//    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    @GetMapping
    public Result list() {
        // 不要使用System.out，专业点，用日志
//        System.out.println("查询全部部门数据");
        log.info("查询全部部门数据");
        // 调用service查询部门数据
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    /**
     * 删除部门
     *
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("根据id删除部门: {}", id);
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 新增部门
     */
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门: {}",dept);
        deptService.add(dept);
        return Result.success();
    }
}
