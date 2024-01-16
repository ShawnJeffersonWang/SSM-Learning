package com.shawn.controller;

// Controller不负责逻辑处理
// Controller只负责接受请求，响应数据

import com.shawn.pojo.Emp;
import com.shawn.pojo.Result;
import com.shawn.service.EmpService;
import com.shawn.service.impl.EmpServiceA;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {

    private EmpService empService = new EmpServiceA();

    // 调用Service获取数据
    @RequestMapping("/listEmp")
    public Result list() {
        List<Emp> empList = empService.listEmp();
        return Result.success(empList);
    }
}
